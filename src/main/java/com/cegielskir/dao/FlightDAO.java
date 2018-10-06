package com.cegielskir.dao;

import com.cegielskir.entity.Flight;

import java.util.List;

public interface FlightDAO {

    void add(Flight flight);
    List<Flight> getList();
    Flight getById(int id);
    void deleteById(int id);
}
