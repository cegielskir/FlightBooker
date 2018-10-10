package com.cegielskir.service.impl;

import com.cegielskir.dao.CrewmanDAO;
import com.cegielskir.entity.Crewman;
import com.cegielskir.service.CrewmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrewmanServiceImpl implements CrewmanService {

    @Autowired
    CrewmanDAO crewmanDAO;

    @Transactional
    @Override
    public Crewman getById(int id) {
        return crewmanDAO.getById(id);
    }

    @Transactional
    @Override
    public void add(Crewman crewman) {
        crewmanDAO.add(crewman);
    }

    @Transactional
    @Override
    public List<Crewman> getList() {
        return crewmanDAO.getList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        crewmanDAO.delete(id);
    }
}
