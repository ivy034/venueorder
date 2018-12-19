package com.venue.venueorder.Controller;

import com.venue.venueorder.DO.Message;
import com.venue.venueorder.Service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.venue.venueorder.Service.MessageService;

import java.util.Date;
import  java.util.List;

@Controller
@RequestMapping("/news")

public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 删除指定id消息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteMessage")
    public String  deleteMessage(@RequestParam("id")Integer id) {
        Message message = messageService.findOne(id);
        messageService.deleteMessageById(id);
        return "message";

    }

    /**
     * 添加消息
     *
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "/addMessage")
    public String addMessage(@RequestParam("title") String title, @RequestParam("content") String content, Model model) {

        Message tempMessage = new Message();
        tempMessage.setTitle(title);
        tempMessage.setContent(content);
        tempMessage.setAnnounceTime(new Date());
        Message resultMessage = messageService.createMessage(tempMessage);
        model.addAttribute("mes", resultMessage);//resultMessage传给mes
        return "message";
    }
//



}
