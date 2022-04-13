package ru.alina.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Gender;
import ru.alina.model.Profile;
import ru.alina.repository.ProfileRepository;

import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class ProfileService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Modifying
    public Profile save(Profile profile, Long userId) {
        profile.setCalories(getCalories(profile));
        if (!profile.isNew() && !Objects.equals(profile.getId(), userId)) {
            throw new RuntimeException("profile and user must have same id");
        }
        log.info("save profile {} with userId {}", profile, userId);
        return repository.save(profile, userId);
    }

    @Transactional
    public void delete(Long id) {
        log.info("delete profile {}", id);
        repository.delete(id);
    }


    public Profile get(Long id) {
        log.info("get profile {}", id);
        return repository.get(id);
    }

    public List<Profile> getAll() {
        log.info("getAll profile");
        return repository.getAll();
    }

    private int getCalories(Profile profile) {
        int result=0;
        if (profile.getGender().equals(Gender.MALE)) {
            result = (int) (((10.0*profile.getStartWeight()) + (6.25 * (double)profile.getHeight()) - (5 * profile.getAge()) + 5) * profile.getActivity().getIndexActivity());
        }
        else if (profile.getGender().equals(Gender.FEMALE)){
            result = (int) (((10.0*profile.getStartWeight()) + (6.25 * (double)profile.getHeight()) - (5 * profile.getAge()) - 161) * profile.getActivity().getIndexActivity());
        }
        return result;
    }

}
