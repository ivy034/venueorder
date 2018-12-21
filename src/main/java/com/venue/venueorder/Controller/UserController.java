 package com.venue.venueorder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.UserService;
import com.venue.venueorder.DO.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;

 @Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String userList(Model m){
        List<User> userList = userService.findAllUser();
        m.addAttribute("u_list", userList);
        return "usermanage";
    }

    /*进入用户登录界面*/
    @GetMapping("/login")
    public String loginUser(){
        return "loginUser";
    }

    /*用户信息页面*/
    @GetMapping("/myInfo")
    public  String myInfo(@RequestParam("userId")Integer userId,Model model){
        User user=userService.findOne(userId);
        model.addAttribute("u", user);
        return "form";
    }

    /*最初页面*/
    @GetMapping("/loginfirst")
    public String login(){
        return "login";
    }

//    @ResponseBody
    @GetMapping("/signIn")
    public  String signIn(@RequestParam("name") String name,//request和表单中的name对应
                         @RequestParam("password") String password,
                         Model model, RedirectAttributes redirectAttributes) {
        User user = userService.findByNameAndPassword(name, password);
        model.addAttribute("u", user);//user传到u,
//        redirectAttributes.addAttribute("user",user);
//        return user;
//        return "redirect:/user/configureThymeleafStaticVars";
        return "index";
    }

//    @Resource
//    @GetMapping("/configureThymeleafStaticVars")
//    private String configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
//        if(viewResolver != null) {
//            String name=user.getName();
//            Map<String, Object> vars = new HashMap<>();
//            vars.put("ctx", name);
////            vars.put("var1", "var1");
////            vars.put("var2", "var2");
//            viewResolver.setStaticVariables(vars);
//        }
//        return "index";
//    }

    /*返回首页*/
    @GetMapping("/index")
    public String index(@RequestParam("userId")Integer userId,Model model){
        User user=userService.findOne(userId);
        model.addAttribute("u", user);
        return  "index";
    }

    /**
     * 删除指定id用户
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id")Integer id) {
        User user = userService.findOne(id);
        userService.deleteUserById(id);
        return "redirect:/user/userList";

    }

    /**
     * 注册用户
     *
     * @param name
     * @param password
     * @return
     */
    @GetMapping("/register")
    public String register(@RequestParam("name") String name,@RequestParam("password") String password) {

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
    @GetMapping("/updateUser")
    public String changePassword(@RequestParam("id") Integer id,
                                 @RequestParam("name") String name,@RequestParam("sex")String sex,@RequestParam("phoneNumber")String phoneNumber,
                                 @RequestParam("email")String email,@RequestParam("selfIntro")String selfIntro) {
        User user = userService.findOne(id);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setSex(sex);
        user.setSelfIntro(selfIntro);
        userService.update(user);
        return "form";
    }


}
