package com.cegielskir.dao.impl;

import com.cegielskir.dao.FlightDetailsDAO;
import com.cegielskir.entity.FlightDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDetailsDAOImpl implements FlightDetailsDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public FlightDetails get(int id) {
        FlightDetails flightDetails = sessionFactory.getCurrentSession().get(FlightDetails.class, id);
        return flightDetails;
    }

    @Override
    public void add(FlightDetails flightDetails) {
        sessionFactory.getCurrentSession().saveOrUpdate(flightDetails);
    }
}
