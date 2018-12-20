package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Venue;
import com.venue.venueorder.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/venue")

public class VenueController {
    @Autowired
    private VenueService venueService;


    @GetMapping("/venueList")
    public String userList(Model m){
        List<Venue> venueList = venueService.findAllVenue();
        m.addAttribute("v_list", venueList);
        return "venuemanage";
    }
    /**
     * 删除指定id场馆
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteVenue")
    public Object deleteVenue(@RequestParam("id")Integer id) {
        venueService.deleteVenueById(id);
        return "redirect:/venue/venueList";
    }
    /*增加场馆*/

    /**
     * 修改场馆信息
     *
     * @param id
     * @param address
     * @param name
     * @return
     */

    @RequestMapping(value = "/updateVenue")
    public Object addVenue(@RequestParam("id") Integer id,@RequestParam("address") String address, @RequestParam("name") String name,@RequestParam("time") String time,
                           @RequestParam("cost") Integer cost) {
        Venue tempVenue = venueService.findOne(id);
        tempVenue.setAddress(address);
        tempVenue.setCost(cost);
        tempVenue.setTime(time);
        tempVenue.setName(name);
        Venue resultVenue = venueService.createVenue(tempVenue);
        return "redirect:/venue/venueList";
    }

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
