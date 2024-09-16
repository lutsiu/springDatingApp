package com.dating.datingApp.service.match;

import com.dating.datingApp.model.Match;

import java.util.List;

public interface MatchService {

    Match getMatch(int id);

    List<Match> getAllUserMatches(int userId);


}
