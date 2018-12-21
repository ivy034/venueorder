package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Message;
import com.venue.venueorder.DO.User;
import com.venue.venueorder.Service.UserService;
import com.venue.venueorder.Service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.MessageService;

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

    /*管理员查看留言列表*/
    @GetMapping("/MessageList")
    public String MessageList(Model m){
        List<Message> messageList = messageService.findAllMessage();
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
    public String  deleteMessage(@RequestParam("id")Integer id) {
        Message message = messageService.findOne(id);
        messageService.deleteMessageById(id);
        return "redirect:/message/MessageList";

    }

    /**
     * 添加留言
     *
     * @param content
     * @return
     */
    @GetMapping("/addMessage")
    public String addMessage(@RequestParam("content") String content,@RequestParam("name")String author,Model model) {

        Message tempMessage = new Message();
        tempMessage.setContent(content);
        java.util.Date d=new java.util.Date();
        tempMessage.setAnnounceTime(new Timestamp(d.getTime()));
        tempMessage.setAuthor(author);
        tempMessage.setStatus("待审核");
        Message resultMessage = messageService.createMessage(tempMessage);
        return "redirect:/message/myMessageList";
    }

    /*通过留言*/
    @GetMapping("/agreeMessageStatus")
    public String agreeMessageStatus(@RequestParam("id") Integer id,Model m) {
        Message message = messageService.findOne(id);
        message.setStatus("已通过");
        messageService.update(message);
        return "redirect:/message/messageList";
    }

    /*拒绝留言*/
    @GetMapping("/refuMessageStatus")
    public String refuMessageStatus(@RequestParam("id") Integer id) {
        Message message = messageService.findOne(id);
        message.setStatus("已拒绝");
        messageService.update(message);
        return "redirect:/message/messageList";
    }


//



}
