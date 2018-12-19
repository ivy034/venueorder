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
        return "index";//html名
    }

    /**
     * 删除指定id用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser")
    public Object deleteUser(@RequestParam("id")Integer id) {
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
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/register")
    public String addUser(@RequestParam("name") String name,@RequestParam("password") String password) {

        List<User> tempUser = userService.findByName(name);
        if(tempUser==null)
        {   User user=new User();
            user.setPhoneNumber(name);
            user.setPassword(password);
        User resultUser = userService.createUser(user);
        return "注册成功！";
        }
        return "注册失败，该用户名已被占用！";
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

    /*修改用户信息*/
}
