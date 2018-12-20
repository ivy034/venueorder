package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Manager;
import com.venue.venueorder.Service.ManagerService;
import com.venue.venueorder.Service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.ManagerService;

import  java.util.List;

@Controller
@RequestMapping("/manager")

public class ManagerController {
    @Autowired
    private ManagerService managerService;
    
    /*进入管理员登录界面*/
    @GetMapping("/login")
    public String index(){
        return "loginAdmin";
    }
    
    /*管理员登录*/
    @GetMapping("/signInAsAdmin")
    public String signIn(@RequestParam("name") String name,
                         @RequestParam("password") String password, Model model) {
        Manager manager = managerService.findByNameAndPassword(name, password);
        model.addAttribute("m", manager);//manager传到m,
        return "index-admin";
    }

    /**
     * 删除指定id管理员
     *
     * @param id
     * @return
     */
    @GetMapping( "/deletemanager/{id}")
    public Object deletemanager(@PathVariable("id")Integer id) {
        Manager manager = managerService.findOne(id);
        if (null == manager) {
            return "删除管理员失败:" + id + "没找到该管理员";
        } else {
            managerService.deleteManagerById(id);
            return "删除管理员成功:" + id;
        }
    }

// 条件查询

    /**
     * 获取姓名是指定内容的管理员
     *
     * @return
     */
    @GetMapping("/getmanager1/{name}")
    public Object getmanager(@PathVariable String name) {
        List<Manager> managerList = managerService.findByName(name);
        if (null != managerList && managerList.size() != 0) {
            return managerList;
        } else {
            return "没找到符合要求的管理员";
        }
    }

    /*修改管理员信息（仅密码）*/
}
