package com.cegielskir.dao;

import com.cegielskir.entity.Flight;
import org.hibernate.SessionFactory;
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
        sessionFactory.getCurrentSession().save(flight);
    }

    @Override
    public List<Flight> getList() {
        TypedQuery<Flight> query= sessionFactory.getCurrentSession().createQuery("from Flight");
        return query.getResultList();
    }
}
