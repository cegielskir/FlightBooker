package com.cegielskir.service;

import com.cegielskir.entity.Flight;

import java.util.List;

public interface FlightService {

    void add(Flight Flight);
    List<Flight> getList();
    Flight getById(int id);
    void deleteById(int id);
}
