package com.cegielskir.controller;

import com.cegielskir.entity.Address;
import com.cegielskir.entity.Airport;
import com.cegielskir.entity.Crewman;
import com.cegielskir.propertyEditor.AddressEditor;
import com.cegielskir.service.AddressService;
import com.cegielskir.service.CrewmanService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/crewman")
public class CrewmanController {

    @Autowired
    CrewmanService crewmanService;

    @Autowired
    AddressService addressService;

    @Autowired
    AddressEditor addressEditor;

    @GetMapping("/list")
    public String getCrewmen(Model model){

        List<Crewman> crewmen = crewmanService.getList();

        model.addAttribute("crewmen", crewmen);
        return "crewman-list";
    }

    @GetMapping("/crewmanForm")
    public String showFormForAdd(Model model){

        Crewman crewman = new Crewman();
        List<Address> addresses = addressService.getList();

        model.addAttribute("crewman", crewman);
        model.addAttribute("addresses", addresses);

        return "crewman-form";
    }

    @PostMapping("/saveCrewman")
    public String saveCrewman(@Valid @ModelAttribute("crewman") Crewman crewman,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "crewman-form";
        } else {
            crewmanService.add(crewman);
            return "redirect:/crewman/list";
        }
    }

    @GetMapping("/deleteCrewman")
    public String delete(@RequestParam("crewmanId") int id, Model model){
        crewmanService.delete(id);

        return "redirect:/crewman/list";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "employmentDate",
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false, 10));
        binder.registerCustomEditor(Date.class, "dismissalDate",
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false, 10));
        binder.registerCustomEditor(Address.class, this.addressEditor);
    }

}
