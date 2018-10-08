package com.cegielskir.dao;

import com.cegielskir.entity.FlightDetails;

public interface FlightDetailsDAO {

    FlightDetails get(int id);
    void add(FlightDetails flightDetails);
}
