package com.dating.datingApp.service.message;


import com.dating.datingApp.dao.message.MessageDAO;
import com.dating.datingApp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO dao;

    @Override
    public Message saveMessage(Message message) {
        return dao.saveMessage(message);
    }

    @Override
    public Message getMessage(int id) {
        return dao.getMessage(id);
    }

    @Override
    public Optional<List<Message>> findMessageByWord(String message) {
        return dao.findMessageByWord(message);
    }

    @Override
    public List<Message> findAllMessagesByChatId(int chatId) {
        return dao.findAllMessagesByChatId(chatId);
    }

    @Override
    public Optional<Message> updateMessage(int messageId, String messageText) {
        return dao.updateMessage(messageId, messageText);
    }

    @Override
    public void deleteMessage(int id) {
        dao.deleteMessage(id);
    }

    @Override
    public int markAsRead(int receiverId, int chatId) {
        return dao.markAsRead(receiverId, chatId);
    }
}
