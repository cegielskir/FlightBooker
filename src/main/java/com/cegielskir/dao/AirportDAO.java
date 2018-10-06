package com.cegielskir.dao;

import com.cegielskir.entity.Airport;

import java.util.List;

public interface AirportDAO {

    void add(Airport airport);
    List<Airport> getList();
    List<String> getCountryList();
    void delete(int id);
    Airport getById(int id);
}
