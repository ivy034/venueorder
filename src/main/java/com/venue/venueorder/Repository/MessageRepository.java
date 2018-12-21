package com.venue.venueorder.Repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.venue.venueorder.DO.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
/**
 * @param: none
 * @description: 对数据库中Message表进行操作
 * @author: KingJ
 * @create: 2018-11-17 17:15
 **/
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
