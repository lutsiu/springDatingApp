package com.dating.datingApp.service.message;


import com.dating.datingApp.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    Message saveMessage(Message message);

    Message getMessage(int id);

    Optional<List<Message>> findMessageByWord(String message);

    List<Message> findAllMessagesByChatId(int chatId);

    Optional<Message> updateMessage(int messageId, String messageText);

    void deleteMessage(int id);

    int markAsRead(int receiverId, int chatId);

}
