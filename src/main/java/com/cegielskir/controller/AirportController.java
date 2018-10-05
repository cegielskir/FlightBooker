package com.cegielskir.controller;

import com.cegielskir.entity.Airport;
import com.cegielskir.entity.Flight;
import com.cegielskir.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("/list")
    public String getAirports(Model model){

        List<Airport> airports = airportService.getList();

        model.addAttribute("airports", airports);
        return "airport-list";
    }

    @GetMapping("/airportForm")
    public String showFormForAdd(Model model){

        Airport airport = new Airport();

        model.addAttribute("airport", airport);

        return "airport-form";
    }

    @PostMapping("/saveAirport")
    public String saveAirport(@Valid @ModelAttribute("airport") Airport airport,
                                                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "airport-form";
        } else {
            airportService.add(airport);
            return "redirect:/airport/list";
        }
    }

    @GetMapping("/deleteAirport")
    public String delete(@RequestParam("airportId") int id, Model model){
        airportService.delete(id);

        return "redirect:/airport/list";

    }


}
