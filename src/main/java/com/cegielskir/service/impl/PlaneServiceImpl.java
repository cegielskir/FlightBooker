package com.cegielskir.service.impl;

import com.cegielskir.dao.PlaneDAO;
import com.cegielskir.entity.Plane;
import com.cegielskir.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    PlaneDAO planeDAO;

    @Transactional
    @Override
    public void add(Plane plane) {
        planeDAO.add(plane);
    }

    @Transactional
    @Override
    public Plane getById(int id) {
        return planeDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Plane> getList() {
        return planeDAO.getList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        planeDAO.delete(id);
    }
}
