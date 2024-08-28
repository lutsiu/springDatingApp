package com.dating.datingApp.service.interest;

import com.dating.datingApp.dao.interest.InterestDAO;
import com.dating.datingApp.exceptions.interest.InterestNotFoundException;
import com.dating.datingApp.model.Interest;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestDAO dao;

    @Override
    public Interest findInterestById(int id) {
        return dao.findInterestById(id);
    }

    @Override
    public Interest findInterestByName(String interestName) {

        Optional<Interest> interest = dao.findInterestByName(interestName);
        System.out.println(interest);
        if (interest.isPresent()) {
            return interest.get();
        } else {
            throw new InterestNotFoundException(interestName);
        }
    }

    @Override
    public List<Interest> findAllInterests() {
        return dao.findAllInterests();
    }

    @Override
    public void saveInterest(Interest interest) {
        dao.saveInterest(interest);
    }

    @Override
    public void deleteInterest(int id) {
        dao.deleteInterest(id);
    }
}
