package com.cegielskir.service.impl;

import com.cegielskir.dao.FlightDAO;
import com.cegielskir.entity.Flight;
import com.cegielskir.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightDAO flightDAO;

    @Transactional
    @Override
    public void add(Flight flight) {
        flightDAO.add(flight);
    }

    @Transactional
    @Override
    public List<Flight> getList() {
        return flightDAO.getList();
    }

    @Transactional
    @Override
    public Flight getById(int id) {
        return flightDAO.getById(id);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        flightDAO.deleteById(id);
    }
}
