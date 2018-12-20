package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Order;
import com.venue.venueorder.DO.Venue;
import com.venue.venueorder.Service.VenueService;
import com.venue.venueorder.Service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.OrderService;

import java.sql.Date;
import  java.util.List;
import java.util.zip.DataFormatException;

@Controller
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;
    private VenueService venueService;

    @GetMapping("/myOrderList")
    public String myOrderList(@RequestParam("userId")Integer userId, Model m){
//        Order orderList = orderService.findOne(userId);
        List<Order> orderList = orderService.findByUserId(userId);
//        return orderList;
        m.addAttribute("myo_list", orderList);
        return "order";
    }

    @GetMapping("/orderList")
    public String orderList(Model m){
        List<Order> orderList = orderService.findAllOrder();
        m.addAttribute("o_list", orderList);
        return "ordermanage";
    }

    /**
     * 删除指定id订单
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteMyOrder")
    public String deleteMyOrder(@RequestParam("id") Integer id) {
            orderService.deleteOrderById(id);
            return "redirect:/order/myOrderList";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("id") Integer id) {
        orderService.deleteOrderById(id);
        return "redirect:/order/orderList";
    }

    /**
     * 添加订单
     *
     * @param userId
     * @param venueId
     * @param venueTime
     * @return
     */
    @GetMapping("/addOrder")
    public void addOrder(@RequestParam("userId") Integer userId, @RequestParam("venueId") Integer venueId , @RequestParam("venueTime") String venueTime, Model model) {

        Order tempOrder = new Order();
        tempOrder.setUserId(userId);
        tempOrder.setVenueId(venueId);
        Venue tempVenue=venueService.findOne(venueId);
        String venueName=tempVenue.getName();
//        java.util.Date d=new java.util.Date();
//        java.sql.Date date=new java.sql.Date(d.getTime());
//        tempOrder.setCreateTime();
        tempOrder.setVenueName(venueName);
        tempOrder.setVenueTime(venueTime);
        tempOrder.setStatus("未审核");
        tempOrder.setCost(orderService.findOne(venueId).getCost());
        Order resultOrder = orderService.createOrder(tempOrder);
        model.addAttribute("o", resultOrder);//resultOrder传到o,
    }
// 条件查询

    /**
     * 获取用户id是指定内容的订单
     *
     * @return
     */
    @GetMapping( "/getOrder1")
    public Object getOrder(Integer id) {
        List<Order> orderList = orderService.findByUserId(id);
        if (null != orderList && orderList.size() != 0) {
            return orderList;
        } else {
            return "没找到符合要求的订单";
        }
    }

   /*通过订单*/
  @GetMapping("/agreeOrderStatus")
  public String changePassword(@RequestParam("id") Integer id,Model m) {
      Order order = orderService.findOne(id);
      order.setStatus("已通过");
      orderService.update(order);
      return "redirect:/order/orderList";
  }

  /*拒绝订单*/
  @GetMapping("/refuOrderStatus")
  public String changePassword(@RequestParam("id") Integer id) {
      Order order = orderService.findOne(id);
      order.setStatus("未通过");
      orderService.update(order);
      return "redirect:/order/orderList";
  }


}
