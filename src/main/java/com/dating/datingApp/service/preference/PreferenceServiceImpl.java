package com.dating.datingApp.service.preference;

import com.dating.datingApp.dao.preference.PreferenceDAO;
import com.dating.datingApp.exceptions.preference.PreferenceNotFoundException;
import com.dating.datingApp.model.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceDAO dao;

    @Override
    public Preference savePreference(Preference preference) {
        return dao.savePreference(preference);
    }

    @Override
    public Preference getPreference(int id) {
        Preference preference = dao.getPreference(id);

        if (preference == null) {
            throw new PreferenceNotFoundException(id);
        }
        return dao.getPreference(id);
    }

    @Override
    public Preference changePreference(Preference preference) {
        return dao.changePreference(preference);
    }

    @Override
    public void deletePreference(int id) {
        Preference preference = dao.getPreference(id);
        if (preference == null) {
            throw new PreferenceNotFoundException(id);
        }
        dao.deletePreference(id);
    }
}
