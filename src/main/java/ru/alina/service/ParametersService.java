package ru.alina.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Parameters;
import ru.alina.model.User;
import ru.alina.repository.ParametersRepository;
import ru.alina.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ParametersService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final ParametersRepository repository;
    private final UserRepository userRepository;

    public ParametersService(ParametersRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Transactional
    @Modifying
    public Parameters save(Parameters parameters, Long userId) {
        if (parameters.getId() == null && parameters.getUser() == null) {
            parameters.setId(userId);
            User user = userRepository.get(userId);
            parameters.setUser(user);
        }

        log.info("save parameters {} with userId {}", parameters, userId);
        return repository.save(parameters, userId);
    }

    @Transactional
    public void delete(Long id) {
        log.info("delete parameters {}", id);
        repository.delete(id);
    }


    public Parameters get(Long id) {
        log.info("get parameters {}", id);
        return repository.get(id);
    }

    public List<Parameters> getAll() {
        log.info("getAll parameters");
        return repository.getAll();
    }

}
