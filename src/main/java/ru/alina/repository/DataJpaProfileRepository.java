package ru.alina.repository;

import org.springframework.stereotype.Repository;
import ru.alina.model.Profile;

import java.util.List;

@Repository
public class DataJpaProfileRepository implements ProfileRepository {


    private final DataJpaProfile dataJpaProfile;

    public DataJpaProfileRepository(DataJpaProfile dataJpaProfile) {
        this.dataJpaProfile = dataJpaProfile;
    }

    @Override
    public Profile save(Profile profile, Long userId) {

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
