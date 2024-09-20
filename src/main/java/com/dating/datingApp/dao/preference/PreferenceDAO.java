package com.dating.datingApp.dao.preference;

import com.dating.datingApp.model.Preference;

public interface PreferenceDAO {
    Preference savePreference(Preference preference);

    Preference getPreference(int id);

    Preference changePreference(Preference preference);

    void deletePreference(int id);
}
