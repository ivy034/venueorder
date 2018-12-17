package com.venue.venueorder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.venue.venueorder.DO.User;
import java.util.List;
/**
 * @param: none
 * @description: 对数据库中User表进行操作
 * @author: KingJ
 * @create: 2018-11-17 17:15
 **/
public interface UserRepository extends JpaRepository<User/*实体类名*/, Integer/*主键类型*/> {
    List<User> findByName(String name);//根据用户名查询
    User findByNameAndPassword(String name,String email);//根据用户名和密码进行查询
//    sql语句：选择插入更新删除where

}
