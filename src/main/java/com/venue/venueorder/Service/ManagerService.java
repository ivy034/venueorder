package com.venue.venueorder.Service;

import com.venue.venueorder.DO.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ManagerService {
    Manager findOne(Integer id);

    Manager findByNameAndPassword(String name, String password);

    Manager createManager(Manager manager);

    void deleteManagerById(Integer id);

    List<Manager> findByName(String name);//根据管理员名查询
}
