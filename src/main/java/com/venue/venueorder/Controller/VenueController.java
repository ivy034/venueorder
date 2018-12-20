package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Venue;
import com.venue.venueorder.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/venue")

public class VenueController {
    @Autowired
    private VenueService venueService;


    /**
     * 删除指定id场馆
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteVenue")
    public Object deleteVenue(@RequestParam("id")Integer id) {
        Venue venue = venueService.findOne(id);
        if (null == venue) {
            return "删除场馆失败:" + id + "没找到该场馆";
        } else {
            venueService.deleteVenueById(id);
            return "删除场馆成功:" + id;
        }
    }
    /*修改场馆信息*/

    /**
     * 添加場館
     *
     * @param id
     * @param address
     * @param name
     * @return
     */
   /*
    @RequestMapping(value = "/addvenue")
    public Object addVenue(Integer id, String address, String name,String time, Integer cost) {
        System.out.println("address:" + address);

        System.out.println("Id:" + id +  "name:" + name+ "time"+time+"address:" + address );

        Venue tempVenue = venueService.findOne(id);
        if (null == tempVenue) {
            tempVenue = new Venue();
            tempVenue.setId(id);
        }
        tempVenue.setAddress(address);
        tempVenue.setCost(cost);
        tempVenue.setTime(time);
        tempVenue.setName(name);
        Venue resultVenue = venueService.createVenue(tempVenue);
        if (null == resultVenue) {
            return "新增场馆失败";
        } else {
            return "新增场馆:" + resultVenue.getName();
        }
    }
    */

// 条件查询

    /**
     * 获取姓名是指定内容的場館
     *
     * @return
     */
    @RequestMapping(value = "/getVenue1")
    public Object getVenue(String name) {
        List<Venue> venueList = venueService.findByName(name);
        if (null != venueList && venueList.size() != 0) {
            return venueList;
        } else {
            return "没找到符合要求的场馆";
        }
    }


}
