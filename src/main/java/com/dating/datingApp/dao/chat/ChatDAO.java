package com.dating.datingApp.dao.chat;

import com.dating.datingApp.model.Chat;

import java.util.Optional;

public interface ChatDAO {

    Chat createChat(Chat chat);

    Chat getChat(int id);

    void deleteChat(int chatId);

    Optional<Chat> findChatByUsers(int userId1, int userId2);


}
