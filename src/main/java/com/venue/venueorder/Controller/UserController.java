
12:40:14
        甘老师 2018/12/20 12:40:14
        待会儿来吗

        Fairy 2018/12/20 12:40:35
        可以来
        12:43:31
        甘老师 2018/12/20 12:43:31
        来
        13:23:21
        甘老师 2018/12/20 13:23:21
        package com.surveyor.surveyorwebservice.Controller;

import com.surveyor.surveyorwebservice.DO.User;
import com.surveyor.surveyorwebservice.Service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @param: none
 * @description: user controller
 * @author: KingJ
 * @create: 2018-11-28 00:54
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String userList(Model m){
        List<User> userList = userService.findAllUser();
        m.addAttribute("usr_list", userList);
        return "userInfo";
    }

    @GetMapping("/login")
    public String index(){
        return "login";
    }

    @ResponseBody
    @GetMapping("/getInfoByID/{id}")
    public User findUserByID(@PathVariable("id") Integer id){
        return userService.findOne(id);
    }

    @ResponseBody
    @GetMapping("/getInfo/{name}")
    public User findUserByName(@PathVariable("name")String name) { return userService.findByName(name); }

    @GetMapping("/signIn")
    public String signIn(@RequestParam("name") String name,
                         @RequestParam("password") String password,
                         Model model) {
        User user = userService.findByNameAndPassword(name, password);
        model.addAttribute("usr_list", user);
        return "redirect:/user/";
    }

    @GetMapping("/insert")
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("password") String password,
                             @RequestParam("phoneNumber") String phoneNum,
                             @RequestParam("email") String email,
                             Model m){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNum);
        user.setEmail(email);
        User new_user = userService.createUser(user);
        m.addAttribute("usr_list", new_user);
        return "redirect:/user/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/user/";
    }

    @GetMapping("/update")
    public String changePassword(@RequestParam("id") Integer id,
                                 @RequestParam("name") String name) {
        User user = userService.findOne(id);
        user.setName(name);
        userService.updatePassword(user);
        return "redirect:/user/";
    }

}
