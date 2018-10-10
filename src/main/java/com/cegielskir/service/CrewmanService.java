package com.cegielskir.service;

import com.cegielskir.entity.Crewman;

import java.util.List;

public interface CrewmanService {

    Crewman getById(int id);
    void add(Crewman crewman);
    List<Crewman> getList();
    void delete(int id);
}
