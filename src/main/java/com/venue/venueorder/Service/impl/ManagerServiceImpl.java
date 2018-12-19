package com.venue.venueorder.Service.impl;

import com.venue.venueorder.DO.Manager;
import com.venue.venueorder.Repository.ManagerRepository;
import com.venue.venueorder.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    public ManagerRepository managerRepository;

    @Override
    public Manager findOne(Integer id)
    {return managerRepository.findById(id).get();};

    @Override
    public Manager findByNameAndPassword(String name, String password){
        return managerRepository.findByNameAndPassword(name, password);
    }

    @Override
    public Manager createManager(Manager manager){
        return managerRepository.save(manager);
    }

    @Override
    public void deleteManagerById(Integer id){
        managerRepository.deleteById(id);
    }

    @Override
    public List<Manager> findByName(String name){
        return managerRepository.findByName(name);
    }//根据管理员名查询

}
