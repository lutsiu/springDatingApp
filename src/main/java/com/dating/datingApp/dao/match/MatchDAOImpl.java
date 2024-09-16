package com.dating.datingApp.dao.match;

import com.dating.datingApp.model.Match;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MatchDAOImpl implements MatchDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Match saveMatch(Match match) {
        entityManager.persist(match);
        return match;
    }

    @Override
    public Match getMatch(int id) {
        return entityManager.find(Match.class, id);
    }

    @Override
    public List<Match> getAllUserMatches(int userId) {
        String query = "SELECT m FROM Match m WHERE m.userId1 = :userId OR m.userId2 = :userId";

        return entityManager.createQuery(query, Match.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Optional<Match> findMatchByUserId(int userId1, int userId2) {
        String query = "SELECT m FROM Match m WHERE (m.userId1 = :userId1 AND m.userId2 = :userId2) " +
                "OR (m.userId1 = :userId2 AND m.userId2 = :userId1)";
        return entityManager.createQuery(query, Match.class)
                .setParameter("userId1", userId1)
                .setParameter("userId2", userId2)
                .getResultStream()
                .findFirst();
    }

    @Override
    @Transactional
    public void deleteMatch(int id) {
        Match match = entityManager.find(Match.class, id);
        if (match != null) {
            entityManager.remove(match);
        }
    }
}
