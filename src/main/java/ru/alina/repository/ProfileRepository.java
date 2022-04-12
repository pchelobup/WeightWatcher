package ru.alina.repository;

import ru.alina.model.Profile;

import java.util.List;

public interface ProfileRepository {
    Profile save(Profile profile, Long userId);

    void delete(Long id);

    // null if not found
    Profile get(Long id);

    List<Profile> getAll();
}
