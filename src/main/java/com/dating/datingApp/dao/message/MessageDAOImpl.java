package com.dating.datingApp.dao.message;

import com.dating.datingApp.model.Chat;
import com.dating.datingApp.model.Message;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Message saveMessage(Message message) {
        entityManager.persist(message);
        return message;
    }

    @Override
    public Message getMessage(int id) {
        return entityManager.find(Message.class, id);
    }

    @Override
    public Optional<List<Message>> findMessageByWord(String message) {
        String query = "SELECT m FROM Message m WHERE m.messageText LIKE :word";
        List<Message> messages = entityManager.createQuery(query, Message.class)
                .setParameter("word", "%" + message + "%")
                .getResultList();

        return messages.isEmpty() ? Optional.empty() : Optional.of(messages);
    }

    @Override
    public List<Message> findAllMessagesByChatId(int chatId) {
        String query = "SELECT m from Message m WHERE m.chatId = :chatId";
        return entityManager
                .createQuery(query, Message.class)
                .setParameter("chatId", chatId)
                .getResultList();
    }

    @Override
    @Transactional
    public int markAsRead(int chatId, int messageId, int receiverId) {
        String query = "UPDATE Message m SET m.readAt = :now WHERE m.chatId " +
                "= :chatId AND m.id = :messageId AND m.senderId != :receiverId AND m.readAt IS NULL ";
        int updatedRows = entityManager.createQuery(query)
                .setParameter("now", LocalDateTime.now())
                .setParameter("chatId", chatId)
                .setParameter("messageId", messageId)
                .setParameter("receiverId", receiverId)
                .executeUpdate();
        return updatedRows;
    }

    @Override
    @Transactional
    public Optional<Message> updateMessage(int messageId, String messageText) {
        Message message = getMessage(messageId);
        if (message != null) {
            message.setMessageText(messageText);
            entityManager.merge(message);
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void deleteMessage(int messageId) {
        Message message = getMessage(messageId);
        if (message != null) {
            entityManager.remove(message);
        }
    }


}
