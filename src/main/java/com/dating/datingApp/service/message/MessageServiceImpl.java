package com.dating.datingApp.service.message;


import com.dating.datingApp.dao.chat.ChatDAO;
import com.dating.datingApp.dao.message.MessageDAO;
import com.dating.datingApp.dao.user.UserDAO;
import com.dating.datingApp.exceptions.chat.ChatNotFoundException;
import com.dating.datingApp.exceptions.message.MessageNotFoundException;
import com.dating.datingApp.exceptions.message.MessageTextIsEmptyException;
import com.dating.datingApp.exceptions.message.MessageWasMarkedAsRead;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.model.Chat;
import com.dating.datingApp.model.Message;
import com.dating.datingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO dao;

    @Autowired
    private ChatDAO chatDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Message saveMessage(Message message) {
        String messageText = message.getMessageText().trim();
        if (messageText.isEmpty()) {
            throw new MessageTextIsEmptyException();
        } else {
            message.setMessageText(messageText);
            return dao.saveMessage(message);
        }
    }

    @Override
    public Message getMessage(int id) {
        Message message = dao.getMessage(id);
        if (message == null) {
            throw new MessageNotFoundException(id);
        }
        return message;
    }

    @Override
    public Optional<List<Message>> findMessageByWord(String message) {
        return dao.findMessageByWord(message);
    }

    @Override
    public List<Message> findAllMessagesByChatId(int chatId) {
        Chat chat = chatDAO.getChat(chatId);
        if (chat == null) {
            throw new ChatNotFoundException(chatId);
        }
        return dao.findAllMessagesByChatId(chatId);
    }

    @Override
    public Optional<Message> updateMessage(int messageId, String messageText) {
        Message message = dao.getMessage(messageId);
        if (message == null) {
            throw new MessageNotFoundException(messageId);
        }
        if (messageText.trim().isEmpty()) {
            throw new MessageTextIsEmptyException();
        }
        return dao.updateMessage(messageId, messageText.trim());
    }

    @Override
    public void deleteMessage(int id) {
        Message message = dao.getMessage(id);
        if (message == null) {
            throw new MessageNotFoundException(id);
        }
        dao.deleteMessage(id);
    }

    @Override
    public int markAsRead(int chatId, int messageId, int receiverId) {
        Chat chat = chatDAO.getChat(chatId);
        Message message = dao.getMessage(messageId);
        User user = userDAO.getUser(receiverId);
        if (message.getReadAt() != null) {
            throw new MessageWasMarkedAsRead(messageId);
        }
        if (chat == null) {
            throw new ChatNotFoundException(chatId);
        }
        if (message == null) {
            throw new MessageNotFoundException(messageId);
        }
        if (user == null) {
            throw new UserNotFoundException(receiverId);
        }
        return dao.markAsRead( chatId, messageId, receiverId);
    }
}
