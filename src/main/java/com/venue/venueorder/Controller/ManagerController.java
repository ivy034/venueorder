package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Manager;
import com.venue.venueorder.Service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.ManagerService;

import  java.util.List;

@Controller
@RequestMapping("/manager")

public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @GetMapping("/signIn")
    public Manager signIn(@RequestParam("name") String name,
                       @RequestParam("password") String password) {
        return managerService.findByNameAndPassword(name, password);
    }

    /**
     * 删除指定id管理员
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteManager/{id}")
    public Object deleteManager(@PathVariable("id")Integer id) {
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
    @RequestMapping(value = "/getManager1/{name}")
    public Object getManager(@PathVariable String name) {
        List<Manager> managerList = managerService.findByName(name);
        if (null != managerList && managerList.size() != 0) {
            return managerList;
        } else {
            return "没找到符合要求的管理员";
        }
    }

    /*修改管理员信息（仅密码）*/
}
