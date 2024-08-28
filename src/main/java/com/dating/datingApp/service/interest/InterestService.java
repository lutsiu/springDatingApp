package com.dating.datingApp.service.interest;

import com.dating.datingApp.model.Interest;

import java.util.List;
import java.util.Optional;

public interface InterestService {

    Interest findInterestById(int id);

    Interest findInterestByName(String interestName);

    List<Interest> findAllInterests();

    void saveInterest(Interest interest);

    void deleteInterest(int id);
}
