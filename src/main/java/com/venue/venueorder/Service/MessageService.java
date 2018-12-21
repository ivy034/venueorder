package com.venue.venueorder.Service;

import com.venue.venueorder.DO.Message;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    Message findOne(Integer id);

    List<Message> findAllMessage();

    Message createMessage(Message news);

    void deleteMessageById(Integer id);

    void update(Message message);
}
