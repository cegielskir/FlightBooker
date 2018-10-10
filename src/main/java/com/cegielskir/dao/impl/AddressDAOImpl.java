package com.cegielskir.dao.impl;

import com.cegielskir.dao.AddressDAO;
import com.cegielskir.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Address address) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(address);
    }

    @Override
    public List<Address> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        TypedQuery<Address> addressTypedQuery = currentSession.createQuery("from Address a" +
                " order by a.country", Address.class);
        return addressTypedQuery.getResultList();
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Address address = currentSession.load(Address.class, id);
        currentSession.delete(address);
    }

    @Override
    public Address getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Address.class, id);
    }
}