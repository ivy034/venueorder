package com.venue.venueorder.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.venue.venueorder.Repository.UserRepository;
import com.venue.venueorder.Service.UserService;
import com.venue.venueorder.DO.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public User findOne(Integer id)
    {return userRepository.findById(id).get();};

    @Override
    public User findByNameAndPassword(String name, String password){
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id){
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }//根据用户名查询

}
