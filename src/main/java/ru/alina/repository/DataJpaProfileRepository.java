package ru.alina.repository;

import org.springframework.stereotype.Repository;
import ru.alina.model.Profile;
import ru.alina.model.User;

import java.util.List;

@Repository
public class DataJpaProfileRepository implements ProfileRepository {


    private final DataJpaProfile dataJpaProfile;

    private final DataJpaUser dataJpaUser;

    public DataJpaProfileRepository(DataJpaProfile dataJpaProfile, DataJpaUser dataJpaUser) {
        this.dataJpaProfile = dataJpaProfile;
        this.dataJpaUser = dataJpaUser;
    }

    @Override
    public Profile save(Profile profile, Long userId) {
        if (!profile.isNew() && get(profile.id()) == null) {
            return null;
        }
            profile.setId(userId);
            User user = dataJpaUser.getById(userId);
            profile.setUser(user);

        return dataJpaProfile.save(profile);
    }

    @Override
    public void delete(Long id) {
        dataJpaProfile.deleteById(id);
    }

    @Override
    public Profile get(Long id) {
        return dataJpaProfile.findById(id).orElse(null);
    }

    @Override
    public List<Profile> getAll() {
        return dataJpaProfile.findAll();
    }
}
