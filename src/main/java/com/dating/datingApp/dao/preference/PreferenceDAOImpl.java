package com.dating.datingApp.dao.preference;

import com.dating.datingApp.model.Preference;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PreferenceDAOImpl implements PreferenceDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Preference savePreference(Preference preference) {
        entityManager.persist(preference);
        return preference;
    }

    @Override
    public Preference getPreference(int id) {
        return entityManager.find(Preference.class, id);
    }

    @Override
    @Transactional
    public Preference changePreference(Preference preference) {
        return entityManager.merge(preference);
    }

    @Override
    @Transactional
    public void deletePreference(int id) {
        Preference preference = this.getPreference(id);
        entityManager.remove(preference);
    }
}
