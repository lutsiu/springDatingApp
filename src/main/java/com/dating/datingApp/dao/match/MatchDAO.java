package com.dating.datingApp.dao.match;

import com.dating.datingApp.model.Match;

import java.util.List;
import java.util.Optional;

public interface MatchDAO {

    Match saveMatch(Match match);

    Match getMatch(int matchId);

    Optional<Match> findMatchByUserId(int userId1, int userId2);

    List<Match> getAllUserMatches(int userId);

    void deleteMatch(int id);

}
