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
    public MessageRepository newsRepository;

    @Override
    public Message findOne(Integer id)
    {return newsRepository.findById(id).get();};

    @Override
    public Message createMessage(Message news){
        return newsRepository.save(news);
    }

    @Override
    public void deleteMessageById(Integer id){
        newsRepository.deleteById(id);
    }

    @Override
    public List<Message> findByTitle(String title){
        return newsRepository.findByTitle(title);
    }//根据标题查询

    @Override
    public  Message findByTitleAndAuthor(String title, String author){
        return newsRepository.findByTitleAndAuthor(title,author);
    }

}
