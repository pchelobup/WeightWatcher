package ru.alina.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Gender;
import ru.alina.model.Profile;
import ru.alina.model.User;
import ru.alina.repository.ProfileRepository;
import ru.alina.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProfileService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final ProfileRepository repository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Transactional
    @Modifying
    public Profile save(Profile profile, Long userId) {
        if (profile.getId() == null && profile.getUser() == null) {
            profile.setId(userId);
            User user = userRepository.get(userId);
            profile.setUser(user);
            profile.setCalories(getCalories(profile));
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
