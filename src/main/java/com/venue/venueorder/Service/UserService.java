package com.venue.venueorder.Service;

import com.venue.venueorder.DO.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User findOne(Integer id);

    User findByNameAndPassword(String name, String password);

    User createUser(User user);

    void deleteUserById(Integer id);

    List<User> findByName(String name);//根据用户名查询
}

