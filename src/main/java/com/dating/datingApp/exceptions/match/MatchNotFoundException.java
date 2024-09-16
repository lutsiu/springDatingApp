package com.dating.datingApp.exceptions.match;

public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(int matchId) {
        super("Match with id " + matchId + " wasn't found");
    }

}
