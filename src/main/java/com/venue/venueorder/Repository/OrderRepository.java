package com.venue.venueorder.Repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.venue.venueorder.DO.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
/**
 * @param: none
 * @description: 对数据库中Order表进行操作
 * @author: KingJ
 * @create: 2018-11-17 17:15
 **/
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);//根据用户ID查询
}
