package com.cegielskir.propertyEditor;

import com.cegielskir.entity.Airport;
import com.cegielskir.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class AirportEditor extends PropertyEditorSupport{

    @Autowired
    private AirportService airportService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Airport airport = this.airportService.getById(Integer.valueOf(text));
        this.setValue(airport);
    }

}
