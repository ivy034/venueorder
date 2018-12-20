package com.venue.venueorder.Service;

import com.venue.venueorder.DO.Message;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    Message findOne(Integer id);

    List<Message> findAllMessage();

    Message findByTitleAndAuthor(String title, String author);

    Message createMessage(Message news);

    void deleteMessageById(Integer id);

    List<Message> findByTitle(String title);

    void update(Message message);
}
