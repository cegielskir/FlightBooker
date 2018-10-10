package com.cegielskir.propertyEditor;

import com.cegielskir.entity.Address;
import com.cegielskir.entity.Airport;
import com.cegielskir.service.AddressService;
import com.cegielskir.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class AddressEditor extends PropertyEditorSupport{

    @Autowired
    private AddressService addressService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Address address = this.addressService.getById(Integer.valueOf(text));
        this.setValue(address);
    }

}
