package com.dating.datingApp.dao.interest;

import com.dating.datingApp.exceptions.interest.InterestNotFoundException;
import com.dating.datingApp.model.Interest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class InterestDAOImpl implements InterestDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Interest findInterestById(int id) {
        return entityManager.find(Interest.class, id);
    }

    @Override
    public Optional<Interest> findInterestByName(String interestName) {
        try {
            Interest interest = entityManager.createQuery(
                            "SELECT i FROM Interest i WHERE i.interestName = :name", Interest.class
                    )
                    .setParameter("name", interestName)
                    .getSingleResult();
            return Optional.of(interest);
        } catch (NoResultException e) {
              throw new InterestNotFoundException(interestName);
        }

    }

    @Override
    public List<Interest> findAllInterests() {
        return entityManager.createQuery("from Interest", Interest.class).getResultList();
    }

    @Override
    @Transactional
    public void saveInterest(Interest interest) {
        if (interest.getId() == 0) {
            entityManager.persist(interest);
        } else {
            entityManager.merge(interest);
        }
    }

    @Override
    @Transactional
    public void deleteInterest(int id) {
        Interest interest = findInterestById(id);
        if (interest != null) {
            entityManager.remove(interest);
        }
    }
}
