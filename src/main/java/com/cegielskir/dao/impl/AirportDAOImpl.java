package com.cegielskir.dao.impl;

import com.cegielskir.dao.AirportDAO;
import com.cegielskir.entity.Airport;
import com.cegielskir.entity.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public class AirportDAOImpl implements AirportDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Airport airport) {
        sessionFactory.getCurrentSession().saveOrUpdate(airport);

    }

    @Override
    public List<Airport> getList() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Airport> theQuery = currentSession.createQuery("from Airport order by country", Airport.class);

        List<Airport> airports = theQuery.getResultList();

        return airports;

    }

    @Override
    public List<String> getCountryList() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<String> theQuery = currentSession.createQuery("select airport.country from Airport airport", String.class);

        List<String> countries = theQuery.getResultList();

        return countries;
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Airport airport = (Airport)sessionFactory.getCurrentSession().load(Airport.class, id);
        currentSession.delete(airport);

    }

    @Override
    public Airport getById(int id) {
        Airport airport = (Airport)sessionFactory.getCurrentSession().load(Airport.class, id);
        return airport;
    }
}
