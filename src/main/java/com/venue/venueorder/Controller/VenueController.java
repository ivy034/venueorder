package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Manager;
import com.venue.venueorder.DO.User;
import com.venue.venueorder.DO.Venue;
import com.venue.venueorder.Service.ManagerService;
import com.venue.venueorder.Service.UserService;
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
    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;


    @GetMapping("/venueList")
    public String venueList(Model m){
        List<Venue> venueList = venueService.findAllVenue();
        m.addAttribute("v_list", venueList);

        return "venuemanage";
    }

    @GetMapping("/myVenueList")
    public String myVenueList(@RequestParam("userId")Integer userId, Model m){
        List<Venue> venueList = venueService.findAllVenue();
        User user=userService.findOne(userId);
        m.addAttribute("u", user);
        m.addAttribute("v_list", venueList);
        return "venue";
    }


    /**
     * 删除指定id场馆
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteVenue")
    public String deleteVenue(@RequestParam("id")Integer id) {
        venueService.deleteVenueById(id);
        return "redirect:/venue/venueList";
    }

    /*跳转到添加页面*/
    @GetMapping("/venueAdd")
    public  String venueTo(@RequestParam("managerId")Integer managerId,Model m)
    {
        Manager manager=managerService.findOne(managerId);
        m.addAttribute("m",manager);
        return "venueadd";
    }

    /*跳转到修改页面*/
    @GetMapping("venueUpdate")
    public String venueToo(@RequestParam("managerId")Integer managerId,Model m)
    {
        Manager manager=managerService.findOne(managerId);
        m.addAttribute("m",manager);
        return "venueupdate";
    }

    /*确认添加场馆*/
    @GetMapping("/addVenue")
    public String addVenue(@RequestParam("time")String time,@RequestParam("name")String name,@RequestParam("phoneNumber")String phoneNumber,
                           @RequestParam("cost")Integer cost,@RequestParam("address")String address,Model m)
    {
        Venue tempVenue = new Venue();
        tempVenue.setTime(time);
        tempVenue.setName(name);
        tempVenue.setAddress(address);
        tempVenue.setCost(cost);
        tempVenue.setPhoneNumber(phoneNumber);
        Venue resultVenue = venueService.createVenue(tempVenue);
        return "redirect:/venue/venueList";
    }

    /**
     * 确认修改场馆
     *
     * @param id
     * @param address
     * @param name
     * @return
     */

    @RequestMapping(value = "/updateVenue")
    public String addVenue(@RequestParam("id") Integer id,@RequestParam("address") String address, @RequestParam("name") String name,@RequestParam("time") String time,
                           @RequestParam("cost") Integer cost,@RequestParam("phoneNumber")String phoneNumber) {
        Venue tempVenue = venueService.findOne(id);
        tempVenue.setAddress(address);
        tempVenue.setCost(cost);
        tempVenue.setTime(time);
        tempVenue.setName(name);
        tempVenue.setPhoneNumber(phoneNumber);
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
