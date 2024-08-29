package com.dating.datingApp.service.chat;

import com.dating.datingApp.model.Chat;

public interface ChatService {

    void createChat(Chat chat);

    Chat getChat(int id);

    void deleteChat(int chatId);
}
