package com.venue.venueorder.Repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.venue.venueorder.DO.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
/**
 * @param: none
 * @description: 对数据库中Venue表进行操作
 * @author: KingJ
 * @create: 2018-11-17 17:15
 **/
public interface VenueRepository extends JpaRepository<Venue, Integer> {
    List<Venue> findByName(String name);//根据用户名查询

}
