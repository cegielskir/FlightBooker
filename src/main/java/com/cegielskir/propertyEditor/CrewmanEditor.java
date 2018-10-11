package com.cegielskir.propertyEditor;

import com.cegielskir.entity.Address;
import com.cegielskir.entity.Crewman;
import com.cegielskir.service.AddressService;
import com.cegielskir.service.CrewmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CrewmanEditor extends PropertyEditorSupport {

    @Autowired
    private CrewmanService crewmanService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Crewman crewman = this.crewmanService.getById(Integer.valueOf(text));
        this.setValue(crewman);
    }
}
