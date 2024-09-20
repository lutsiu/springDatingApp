package com.dating.datingApp.exceptions.preference;

public class PreferenceNotFoundException extends RuntimeException {
    public PreferenceNotFoundException(int id) {
        super("Preference with id " + id + " wasn't found");
    }
}
