package com.dating.datingApp.service.preference;

import com.dating.datingApp.dao.preference.PreferenceDAO;
import com.dating.datingApp.dao.user.UserDAO;
import com.dating.datingApp.exceptions.preference.PreferenceNotFoundException;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.model.Preference;
import com.dating.datingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceDAO dao;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Preference savePreference(Preference preference) {
        int userId = preference.getUserId();
        User user = userDAO.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
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
        int userId = preference.getUserId();
        User user = userDAO.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        // update preference

        int preferenceId = preference.getId();
        Preference previousPreference = dao.getPreference(preferenceId);

        if (previousPreference == null) {
            throw new PreferenceNotFoundException(preferenceId);
        }

        previousPreference.setMaxDistance(preference.getMaxDistance());
        previousPreference.setMinAgeRange(preference.getMinAgeRange());
        previousPreference.setMaxAgeRange(preference.getMaxAgeRange());

        return dao.changePreference(previousPreference);
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
