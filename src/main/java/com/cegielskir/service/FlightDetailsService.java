package com.cegielskir.service;

import com.cegielskir.entity.FlightDetails;

public interface FlightDetailsService {

    FlightDetails get(int id);
    void add(FlightDetails flightDetails);
}
