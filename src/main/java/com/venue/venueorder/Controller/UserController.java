package com.venue.venueorder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.UserService;
import com.venue.venueorder.DO.User;
import  java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getinfo/{id}")
    public User userList(@PathVariable("id") Integer id) {
        return userService.findOne(id);
    }

    @GetMapping("/login")
    public String index(){
        return "login";
    }

    @GetMapping("/signIn")
    public String signIn(@RequestParam("name") String name,//request和表单中的name对应
                         @RequestParam("password") String password,
                         Model model) {
        User user = userService.findByNameAndPassword(name, password);
        model.addAttribute("u", user);//user传到u,
        return "usermanage";//html名
    }

    /**
     * 删除指定id用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser")
    public Object deleteUser(int id) {
        User user = userService.findOne(id);
        if (null == user) {
            return "删除用户失败:" + id + "没找到该用户";
        } else {
            userService.deleteUserById(id);
            return "删除用户成功:" + id;
        }
    }

    /**
     * 添加用户
     *
     * @param id
     * @param email
     * @param name
     * @return
     */
    @RequestMapping(value = "/adduser")
    public Object addUser(Integer id, String email, String phoneNumber, String name, String password) {

        User tempUser = userService.findOne(id);
        if (null == tempUser) {
            tempUser = new User();
            tempUser.setId(id);//创建新id
        }
        tempUser.setEmail(email);
        tempUser.setPhoneNumber(phoneNumber);
        tempUser.setPassword(password);
        tempUser.setName(name);
        User resultUser = userService.createUser(tempUser);
        if (null == resultUser) {
            return "新增用户失败";
        } else {
            return "新增用户:" + resultUser.getName();
        }
    }
// 条件查询

    /**
     * 获取姓名是指定内容的用户
     *
     * @return
     */
    @RequestMapping(value = "/getUser1/{name}")
    public Object getUser(@PathVariable String name) {
        List<User> userList = userService.findByName(name);
        if (null != userList && userList.size() != 0) {
            return userList;
        } else {
            return "没找到符合要求的用户";
        }
    }
}
