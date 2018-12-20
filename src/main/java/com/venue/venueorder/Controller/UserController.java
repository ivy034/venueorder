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

    @GetMapping("/userList")
    public String userList(Model m){
        List<User> userList = userService.findAllUser();
        m.addAttribute("u_list", userList);
        return "usermanage";
    }
    @GetMapping("/login")
    public String index(){
        return "loginUser";
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
    @GetMapping("/deleteUser")
    public Object deleteUser(@RequestParam("id")Integer id) {
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
