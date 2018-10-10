package com.cegielskir.dao;

import com.cegielskir.entity.Address;
import com.cegielskir.entity.Airport;

import java.util.List;

public interface AddressDAO {

    void add(Address address);
    List<Address> getList();
    void delete(int id);
    Address getById(int id);
}
