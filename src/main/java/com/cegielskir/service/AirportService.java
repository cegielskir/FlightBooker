package com.cegielskir.service;

import com.cegielskir.entity.Airport;

import java.util.List;

public interface AirportService {

    void add(Airport airport);
    List<Airport> getList();
    List<String> getCountryList();
    void delete(int id);
}
