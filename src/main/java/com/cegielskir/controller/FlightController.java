package com.cegielskir.controller;

import com.cegielskir.entity.Airport;
import com.cegielskir.entity.Flight;
import com.cegielskir.propertyEditor.AirportEditor;
import com.cegielskir.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.cegielskir.service.FlightService;

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
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("BINDING: " + bindingResult);
            return "flight-form";
        } else {
            flightService.add(flight);
            return "redirect:/flight/list";
        }
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
    }






}
