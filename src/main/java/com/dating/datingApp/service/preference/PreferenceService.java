package com.dating.datingApp.service.preference;

import com.dating.datingApp.model.Preference;

public interface PreferenceService {
    Preference savePreference(Preference preference);

    Preference getPreference(int id);

    Preference changePreference(Preference preference);

    void deletePreference(int id);
}
