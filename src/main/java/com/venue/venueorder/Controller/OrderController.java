package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Order;
import com.venue.venueorder.DO.Venue;
import com.venue.venueorder.Service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.OrderService;

import java.util.Date;
import  java.util.List;
import java.util.zip.DataFormatException;

@Controller
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 删除指定id订单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteMyOrder")
    public String deleteMyOrder(@RequestParam("id") Integer id) {
            orderService.deleteOrderById(id);
            return "order";
    }

    @RequestMapping(value = "/deleteOrder")
    public String deleteOrder(@RequestParam("id") Integer id) {
        orderService.deleteOrderById(id);
        return "ordermanage";
    }

    /**
     * 添加订单
     *
     * @param userId
     * @param venueId
     * @param venueTime
     * @return
     */
    @RequestMapping(value = "/addOrder")
    public String addOrder(@RequestParam("userId") Integer userId, @RequestParam("venueId") Integer venueId , @RequestParam("venueTime") String venueTime, Model model) {

        Order tempOrder = new Order();
        tempOrder.setUserId(userId);
        tempOrder.setVenueId(venueId);
        tempOrder.setCreateTime(new Date());
        tempOrder.setStatus("未审核");
        tempOrder.setCost(orderService.findOne(venueId).getCost());
        Order resultOrder = orderService.createOrder(tempOrder);
        model.addAttribute("o", resultOrder);//resultOrder传到o,
        return "order";//html名
    }
// 条件查询

    /**
     * 获取用户id是指定内容的订单
     *
     * @return
     */
    @RequestMapping(value = "/getOrder1")
    public Object getOrder(Integer id) {
        List<Order> orderList = orderService.findByUserId(id);
        if (null != orderList && orderList.size() != 0) {
            return orderList;
        } else {
            return "没找到符合要求的订单";
        }
    }

   /*修改订单信息*/
    /*修改审核状态 passOrderStatus refuOrderStatus 留言类同*/

}
