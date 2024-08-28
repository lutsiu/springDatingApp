package com.dating.datingApp.exceptions.interest;

public class InterestNotFoundException extends RuntimeException {
    public InterestNotFoundException(String interestName) {
        super("Interest with name " + interestName + " wasn't found");
    }
}
