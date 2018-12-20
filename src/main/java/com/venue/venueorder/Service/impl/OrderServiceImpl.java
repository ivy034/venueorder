package com.venue.venueorder.Service.impl;

import com.venue.venueorder.DO.Order;
import com.venue.venueorder.Repository.OrderRepository;
import com.venue.venueorder.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public Order findOne(Integer id)
    {return orderRepository.findById(id).get();}

    @Override
    public List<Order> findByUserId(Integer userId){
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Integer id){
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAllOrder(){return orderRepository.findAll();}

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
}
