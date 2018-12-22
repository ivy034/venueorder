package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Manager;
import com.venue.venueorder.DO.Message;
import com.venue.venueorder.DO.User;
import com.venue.venueorder.Service.ManagerService;
import com.venue.venueorder.Service.UserService;
import com.venue.venueorder.Service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.MessageService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.Date;
import  java.util.List;

@Controller
@RequestMapping("/message")

public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;

    /*管理员查看留言列表*/
    @GetMapping("/MessageList")
    public String MessageList(@RequestParam("managerId")Integer managerId, Model m){
        List<Message> messageList = messageService.findAllMessage();
        Manager manager=managerService.findOne(managerId);
        m.addAttribute("m",managerId);
        m.addAttribute("m_list", messageList);
        return "messagemanage";
    }

    /*用户查看留言列表*/
    @GetMapping("/myMessageList")
    public String myMessageList(@RequestParam("userId")Integer userId, Model m){
        List<Message> messageList = messageService.findAllMessage();
        User user=userService.findOne(userId);
        m.addAttribute("u", user);
        m.addAttribute("m_list", messageList);
        return "message";
    }

    /**
     * 删除指定id留言
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteMessage")
    public String  deleteMessage(@RequestParam("id")Integer id, @RequestParam("managerId")Integer managerId, RedirectAttributes redirectAttributes) {
        Message message = messageService.findOne(id);
        messageService.deleteMessageById(id);
        redirectAttributes.addAttribute("managerId",managerId);
        return "redirect:/message/MessageList";

    }

    /**
     * 添加留言
     *
     * @param content
     * @return
     */
    @GetMapping("/addMessage")
    public String addMessage(@RequestParam("userId")Integer userId,@RequestParam("content") String content,@RequestParam("name")String author,Model model,RedirectAttributes redirectAttributes) {

        Message tempMessage = new Message();
        tempMessage.setContent(content);
        java.util.Date d=new java.util.Date();
        tempMessage.setAnnounceTime(new Timestamp(d.getTime()));
        tempMessage.setAuthor(author);
        tempMessage.setStatus("待审核");
        redirectAttributes.addAttribute("userId",userId);
        Message resultMessage = messageService.createMessage(tempMessage);
        return "redirect:/message/myMessageList";
    }

    /*通过留言*/
    @GetMapping("/agreeMessageStatus")
    public String agreeMessageStatus(@RequestParam("managerId")Integer managerId,@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
        Message message = messageService.findOne(id);
        message.setStatus("已通过");
        messageService.update(message);
        redirectAttributes.addAttribute("managerId",managerId);
        return "redirect:/message/messageList";
    }

    /*拒绝留言*/
    @GetMapping("/refuMessageStatus")
    public String refuMessageStatus(@RequestParam("managerId")Integer managerId,@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
        Message message = messageService.findOne(id);
        message.setStatus("已拒绝");
        messageService.update(message);
        redirectAttributes.addAttribute("managerId",managerId);
        return "redirect:/message/messageList";
    }


//



}
