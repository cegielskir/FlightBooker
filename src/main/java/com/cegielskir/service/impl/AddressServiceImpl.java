package com.cegielskir.service.impl;

import com.cegielskir.dao.AddressDAO;
import com.cegielskir.entity.Address;
import com.cegielskir.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDAO addressDAO;

    @Transactional
    @Override
    public void add(Address address) {
        addressDAO.add(address);
    }

    @Transactional
    @Override
    public List<Address> getList() {
        return addressDAO.getList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        addressDAO.delete(id);
    }

    @Transactional
    @Override
    public Address getById(int id) {
        return addressDAO.getById(id);
    }
}
