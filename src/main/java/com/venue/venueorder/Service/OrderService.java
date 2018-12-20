package com.venue.venueorder.Service;

import com.venue.venueorder.DO.Order;
import com.venue.venueorder.DO.Venue;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrder();

    Order findOne(Integer id);

    List<Order> findByUserId(Integer userId);

    Order createOrder(Order user);

    void deleteOrderById(Integer id);

    void update(Order order);
}
