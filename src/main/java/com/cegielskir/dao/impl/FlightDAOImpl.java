package com.cegielskir.dao.impl;

import com.cegielskir.dao.FlightDAO;
import com.cegielskir.entity.Airport;
import com.cegielskir.entity.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FlightDAOImpl implements FlightDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Flight flight) {
        sessionFactory.getCurrentSession().saveOrUpdate(flight);
    }

    @Override
    public List<Flight> getList() {


        TypedQuery<Flight> query= sessionFactory.getCurrentSession().createQuery("from Flight", Flight.class);
        return query.getResultList();
    }

    @Override
    public Flight getById(int id) {
        Flight flight = sessionFactory.getCurrentSession().get(Flight.class, id);
        return flight;
    }

    @Override
    public void deleteById(int id) {
        Flight flight = sessionFactory.getCurrentSession().load(Flight.class, id);
        sessionFactory.getCurrentSession().delete(flight);

    }
}
