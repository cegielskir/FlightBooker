package com.cegielskir.service;

import com.cegielskir.entity.Plane;

import java.util.List;

public interface PlaneService {

    void add(Plane plane);
    Plane getById(int id);
    List<Plane> getList();
    void delete(int id);
}
