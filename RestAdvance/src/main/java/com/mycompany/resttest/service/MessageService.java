/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.service;

import com.mycompany.resttest.database.DatabaseClass;
import com.mycompany.resttest.exception.DataNotFoundException;
import com.mycompany.resttest.model.Message;
import com.mycompany.resttest.model.SubMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Janaka Anuruddha
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

//    public MessageService() {
//        messages.put(1L, new Message(1L, "Hello World", "Janaka"));
//        messages.put(2L, new Message(2L, "HelloJersey", "Janaka"));
//    }
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long Id) {
        Message message = messages.get(Id);
        if (message == null) {
            throw new DataNotFoundException("No Message Found for ID " + Id);
        }
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long Id) {
        return messages.remove(Id);
    }

    public List<Message> getAllMessages2() {
        SubMessage sb1 = new SubMessage("111111111");
        SubMessage sb2 = new SubMessage("222222222");
        Message m1 = new Message(1L, "Hello World", "Janaka", sb1);
        Message m2 = new Message(2L, "Hello Jersey", "Janaka", sb2);

        List<Message> l = new ArrayList<>();
        l.add(m1);
        l.add(m2);

        return l;
    }

}
