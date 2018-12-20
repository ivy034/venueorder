package com.venue.venueorder.Service.impl;

import com.venue.venueorder.DO.Message;
import com.venue.venueorder.Repository.MessageRepository;
import com.venue.venueorder.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    public MessageRepository messageRepository;

    @Override
    public Message findOne(Integer id)
    {return messageRepository.findById(id).get();};

    @Override
    public Message createMessage(Message message){
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessageById(Integer id){
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> findByTitle(String title){
        return messageRepository.findByTitle(title);
    }//根据标题查询

    @Override
    public  Message findByTitleAndAuthor(String title, String author){
        return messageRepository.findByTitleAndAuthor(title,author);
    }

    @Override
    public List<Message> findAllMessage(){return messageRepository.findAll();}

    @Override
    public void update(Message message) {
        messageRepository.save(message);
    }

}
