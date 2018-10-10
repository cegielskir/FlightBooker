package com.cegielskir.controller;

import com.cegielskir.entity.Address;
import com.cegielskir.entity.Airport;
import com.cegielskir.service.AddressService;
import com.cegielskir.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/list")
    public String getAddresses(Model model){

        List<Address> addresses = addressService.getList();

        model.addAttribute("addresses", addresses);
        return "address-list";
    }

    @GetMapping("/addressForm")
    public String showFormForAdd(Model model){

        Address address = new Address();

        model.addAttribute("address", address);

        return "address-form";
    }

    @PostMapping("/saveAddress")
    public String saveAddress(@Valid @ModelAttribute("address") Address address,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "address-form";
        } else {
            addressService.add(address);
            return "redirect:/address/list";
        }
    }

    @GetMapping("/deleteAddress")
    public String delete(@RequestParam("addressId") int id, Model model){
        addressService.delete(id);

        return "redirect:/address/list";

    }
}
