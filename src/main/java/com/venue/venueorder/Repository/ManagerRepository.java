package com.venue.venueorder.Repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.venue.venueorder.DO.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
/**
 * @param: none
 * @description: 对数据库中Manager表进行操作
 * @author: KingJ
 * @create: 2018-11-17 17:15
 **/
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    List<Manager> findByName(String name);//根据管理员名查询
    Manager findByNameAndPassword(String name,String email);//根据管理员名和密码进行查询

}
