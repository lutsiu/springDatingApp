package com.dating.datingApp.service.chat;

import com.dating.datingApp.dao.chat.ChatDAO;

import com.dating.datingApp.exceptions.chat.ChatAlreadyExists;
import com.dating.datingApp.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatDAO dao;

    @Override
    public void createChat(Chat chat) {
        int userId1 = chat.getUserId1();
        int userId2 = chat.getUserId2();
        Optional<Chat> existingChat = dao.findChatByUsers(userId1, userId2);

        if (existingChat.isPresent()) {
            throw new ChatAlreadyExists(userId1, userId2);
        }

        dao.createChat(chat);

    }

    @Override
    public Chat getChat(int id) {
        return dao.getChat(id);
    }

    @Override
    public void deleteChat(int chatId) {
        dao.deleteChat(chatId);
    }


}
