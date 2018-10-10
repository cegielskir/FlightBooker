package com.cegielskir.service;

import com.cegielskir.entity.Address;

import java.util.List;

public interface AddressService {
    void add(Address address);
    List<Address> getList();
    void delete(int id);
    Address getById(int id);
}
