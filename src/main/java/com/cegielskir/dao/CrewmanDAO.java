package com.cegielskir.dao;

import com.cegielskir.entity.Crewman;

import java.util.List;

public interface CrewmanDAO {

    Crewman getById(int id);
    void add(Crewman crewman);
    List<Crewman> getList();
    void delete(int id);
}
