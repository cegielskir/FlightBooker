package com.cegielskir.dao.impl;

import com.cegielskir.dao.CrewmanDAO;
import com.cegielskir.entity.Crewman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CrewmanDAOImpl implements CrewmanDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Crewman getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Crewman.class, id);
    }

    @Override
    public void add(Crewman crewman) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(crewman);
    }

    @Override
    public List<Crewman> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        TypedQuery<Crewman> crewmanQuery =
                currentSession.createQuery("from Crewman c order by c.lastName", Crewman.class);
        return crewmanQuery.getResultList();
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Crewman crewman = currentSession.load(Crewman.class, id);
        currentSession.delete(crewman);
    }
}
