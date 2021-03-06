package com.cegielskir.controller;

import com.cegielskir.entity.*;
import com.cegielskir.propertyEditor.AirportEditor;
import com.cegielskir.propertyEditor.CrewmanEditor;
import com.cegielskir.propertyEditor.PlaneEditor;
import com.cegielskir.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    AirportService airportService;

    @Autowired
    AirportEditor airportEditor;

    @Autowired
    PlaneService planeService;

    @Autowired
    CrewmanService crewmanService;

    @Autowired
    FlightDetailsService flightDetailsService;

    @Autowired
    PlaneEditor planeEditor;

    @Autowired
    CrewmanEditor crewmanEditor;


    @GetMapping("/list")
    public String getFlights(Model model){

        List<Flight> flights = flightService.getList();

        model.addAttribute("flights", flights);
        return "flight-list";
    }

    @GetMapping("/flightForm")
    public String showFormForAdd(Model model){

        Flight flight = new Flight();

        List<Airport> airports = airportService.getList();

        model.addAttribute("flight", flight);
        model.addAttribute("airports", airports);

        return "flight-form";
    }


    @PostMapping("/saveFlight")
    public String saveFlight(@Valid @ModelAttribute("flight") Flight flight,
                               BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("BINDING: " + bindingResult);
            List<Airport> airports = airportService.getList();
            model.addAttribute("airports", airports);
            return "flight-form";
        } else if (flight.getFromAirport().getId() == flight.getToAirport().getId()) {
            model.addAttribute("error", "You have to choose different airports");
            List<Airport> airports = airportService.getList();
            model.addAttribute("airports", airports);
            return "flight-form";
        } else {
            flightService.add(flight);
            return "redirect:/flight/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String updateFlight(@RequestParam("flightId") int id, Model model){

        Flight flight = flightService.getById(id);
        List<Airport> airports = airportService.getList();


        model.addAttribute("airports", airports);
        model.addAttribute("flight", flight);

        return "flight-form";
    }

    @GetMapping("/deleteFlight")
    public String deleteFlight(@RequestParam("flightId") int id, Model model){

        flightService.deleteById(id);

        return "redirect:/flight/list";
    }

    @GetMapping("/setDetails/{flightId}")
    public String setDetails(@PathVariable("flightId") int id, Model model){

        Flight flight = flightService.getById(id);
        List<Plane> planes = planeService.getList();
        List<Crewman> crewmen = crewmanService.getList();
        FlightDetails details = new FlightDetails();

        model.addAttribute("flight", flight);
        model.addAttribute("planes", planes);
        model.addAttribute("crewmen", crewmen);
        model.addAttribute("details", details);

        return "details-form";

    }

    @PostMapping("/saveDetails/{flightId}")
    public String saveDetails(@PathVariable("flightId") int id, @ModelAttribute("details") FlightDetails flightDetails,
                            Model model){
        Flight flight = flightService.getById(id);
        flightDetails.setFlight(flight);
        flightDetailsService.add(flightDetails);
        flight.setFlightDetails(flightDetails);
        flightService.add(flight);
        System.out.println("| --> " +flight.getFlightDetails());
        return "redirect:/flight/list";
    }

    @GetMapping("/showDetails/{flightId}")
    public String showDetails(@PathVariable("flightId") int id, Model model){
        Flight flight = flightService.getById(id);
        FlightDetails flightDetails = flight.getFlightDetails();
        model.addAttribute("flight", flight);
        model.addAttribute("flightDetails", flightDetails);

        return "flight-details";
    }



    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class, "departureDate",
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false, 10));
        binder.registerCustomEditor(       Date.class, "arrivalDate",
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false, 10));
        binder.registerCustomEditor(       Date.class,"departureTime",
                new CustomDateEditor(new SimpleDateFormat("hh:mm"), false, 5));
        binder.registerCustomEditor(       Date.class,"arrivalTime",
                new CustomDateEditor(new SimpleDateFormat("hh:mm"), false, 5));
        binder.registerCustomEditor(Airport.class, this.airportEditor);
        binder.registerCustomEditor(Plane.class, this.planeEditor);
        binder.registerCustomEditor(Crewman.class, this.crewmanEditor);
        binder.registerCustomEditor(List.class, "crewmen", new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element){
                    return crewmanService.getById(Integer.valueOf((String)element));
            }
        });

    }






}
