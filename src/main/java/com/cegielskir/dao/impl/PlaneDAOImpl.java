package com.cegielskir.dao.impl;

import com.cegielskir.dao.PlaneDAO;
import com.cegielskir.entity.Plane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaneDAOImpl implements PlaneDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Plane plane) {
        sessionFactory.getCurrentSession().saveOrUpdate(plane);
    }

    @Override
    public Plane getById(int id) {
        Plane plane = sessionFactory.getCurrentSession().get(Plane.class, id);
        return plane;
    }

    @Override
    public List<Plane> getList() {

        Query<Plane> planeQuery = sessionFactory.getCurrentSession().createQuery("from Plane", Plane.class);
        return planeQuery.getResultList();
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Plane plane = currentSession.load(Plane.class, id);
        currentSession.delete(plane);
    }
}
