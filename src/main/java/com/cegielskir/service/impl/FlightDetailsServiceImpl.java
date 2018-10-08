package com.cegielskir.service.impl;

import com.cegielskir.dao.FlightDetailsDAO;
import com.cegielskir.entity.FlightDetails;
import com.cegielskir.service.FlightDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService{

    FlightDetailsDAO flightDetailsDAO;

    @Transactional
    @Override
    public FlightDetails get(int id) {
        return flightDetailsDAO.get(id);
    }

    @Transactional
    @Override
    public void add(FlightDetails flightDetails) {
        flightDetailsDAO.add(flightDetails);
    }
}
