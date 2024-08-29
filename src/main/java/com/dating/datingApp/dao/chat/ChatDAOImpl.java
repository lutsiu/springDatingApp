package com.dating.datingApp.dao.chat;

import com.dating.datingApp.exceptions.chat.ChatAlreadyExists;
import com.dating.datingApp.model.Chat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class ChatDAOImpl implements ChatDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public Chat createChat(Chat chat) {

        return entityManager.merge(chat);

    }

    @Override
    public Chat getChat(int id) {
        return entityManager.find(Chat.class, id);
    }

    @Override
    public Optional<Chat> findChatByUsers(int userId1, int userId2) {
        String query = "SELECT c from Chat c WHERE (c.userId1 = :userId1 AND c.userId2= :userId2)" +
                " OR (c.userId1 = :userId2 AND c.userId2= :userId1)";
        try {
            Chat chat = entityManager
                    .createQuery(query, Chat.class)
                    .setParameter("userId1", userId1)
                    .setParameter("userId2", userId2)
                    .getSingleResult();
            return Optional.of(chat);
        } catch (NoResultException e) {
            throw new ChatAlreadyExists(userId1, userId2);
        }
    }

    @Override
    @Transactional
    public void deleteChat(int chatId) {
        Chat chat = getChat(chatId);

        if (chat != null) {
            entityManager.remove(chat);
        }
    }




}
