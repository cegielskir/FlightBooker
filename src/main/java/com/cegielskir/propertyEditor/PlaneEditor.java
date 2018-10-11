package com.cegielskir.propertyEditor;

import com.cegielskir.entity.Address;
import com.cegielskir.entity.Plane;
import com.cegielskir.service.AddressService;
import com.cegielskir.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PlaneEditor extends PropertyEditorSupport {

    @Autowired
    private PlaneService planeService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Plane plane = this.planeService.getById(Integer.valueOf(text));
        this.setValue(plane);
    }
}
