package ru.alina.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.User;
import ru.alina.repository.UserRepository;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(int id){
        userRepository.delete(id);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }
}
