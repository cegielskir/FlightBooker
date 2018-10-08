package com.cegielskir.dao;

import com.cegielskir.entity.Plane;

import java.util.List;

public interface PlaneDAO {

    void add(Plane plane);
    Plane getById(int id);
    List<Plane> getList();
    void delete(int id);
}
