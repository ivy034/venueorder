package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Message;
import com.venue.venueorder.Service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.MessageService;

import java.util.Date;
import  java.util.List;

@Controller
@RequestMapping("/message")

public class MessageController {
    @Autowired
    private MessageService messageService;

    /*留言列表*/
    @GetMapping()
    public String messageList(Model m){
        List<Message> messageList = messageService.findAllMessage();
        m.addAttribute("m_list", messageList);
        return "messagemanage";
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
        return "redirect:/message/messageList";

    }

    /**
     * 添加留言
     *
     * @param title
     * @param content
     * @return
     */
    @GetMapping("/addMessage")
    public String addMessage(@RequestParam("title") String title, @RequestParam("content") String content,@RequestParam("name")String author,Model model) {

        Message tempMessage = new Message();
        tempMessage.setTitle(title);
        tempMessage.setContent(content);
        tempMessage.setAnnounceTime(new Date());
        Message resultMessage = messageService.createMessage(tempMessage);
        model.addAttribute("m", resultMessage);//resultMessage传给mes
        return "redirect:/message/messageList";
    }
//



}
