package com.cegielskir.controller;

import com.cegielskir.entity.Airport;
import com.cegielskir.entity.Plane;
import com.cegielskir.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/plane")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @GetMapping("/list")
    public String getPlanes(Model model){

        List<Plane> planes = planeService.getList();

        model.addAttribute("planes", planes);

        return "plane-list";
    }

    @PostMapping("/savePlane")
    public String savePlane(@ModelAttribute("plane") Plane plane, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "plane-form";
        } else {
            planeService.add(plane);
            return "redirect:/plane/list";
        }
    }

    @GetMapping("/planeForm")
    public String showFormForAdd(Model model){
        Plane plane = new Plane();

        model.addAttribute("plane", plane);
        return "plane-form";
    }

    @GetMapping("/deleteFlight")
    public String deleteFlight(@RequestParam("flightId") int id, Model model){
        planeService.delete(id);
        return "redirect:/plane-list";
    }

    @GetMapping("/showFormForAdd")
    public String planeForm(Model model){
        Plane plane = new Plane();
        model.addAttribute("plane", plane);

        return "plane-form";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class, "purchaseDate",
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false, 10));

    }
}
