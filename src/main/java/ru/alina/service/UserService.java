package ru.alina.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.User;
import ru.alina.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        log.info("save user {}", user);
        return userRepository.save(user);
    }

    @Transactional
    public void delete(int id){
        log.info("delete user {}", id);
        userRepository.delete(id);
    }

    public User get(int id) {
        log.info("get user {}", id);
        return userRepository.get(id);
    }

    public List<User> getAll(){
        log.info("getAll user");
        return userRepository.getAll();
    }

    public Optional<User> getByEmail(String email){
        log.info("get user by email {}",email);
        return  userRepository.getByEmail(email);
    }

    public boolean isLoginExist(String email) {
        return userRepository.getByEmail(email).isPresent();
    }
}
