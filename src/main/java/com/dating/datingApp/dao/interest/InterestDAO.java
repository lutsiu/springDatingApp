package com.dating.datingApp.dao.interest;

import com.dating.datingApp.model.Interest;

import java.util.List;
import java.util.Optional;

public interface InterestDAO {
    Interest findInterestById(int id);

    Optional<Interest> findInterestByName(String interestName);

    List<Interest> findAllInterests();

    void saveInterest(Interest interest);

    void deleteInterest(int id);
}
