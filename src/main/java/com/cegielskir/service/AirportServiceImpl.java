package com.cegielskir.service;

import com.cegielskir.dao.AirportDAO;
import com.cegielskir.dao.FlightDAO;
import com.cegielskir.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportDAO airportDAO;

    @Transactional
    @Override
    public void add(Airport airport) {
        airportDAO.add(airport);
    }

    @Transactional
    @Override
    public List<Airport> getList() {
        return airportDAO.getList();
    }

    @Transactional
    @Override
    public List<String> getCountryList() {
        return airportDAO.getCountryList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        airportDAO.delete(id);
    }
}
