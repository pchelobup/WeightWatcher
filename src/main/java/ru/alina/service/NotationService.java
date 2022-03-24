package ru.alina.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Notation;
import ru.alina.repository.NotationRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NotationService {
    private final Logger log = LoggerFactory.getLogger(NotationService.class);
    private final NotationRepository weightRepository;

    public NotationService(NotationRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Transactional
    public Notation save(Notation notation, int userId){
        log.info("save {} for user {}", notation, userId);
        return weightRepository.save(notation, userId);
    }

    @Transactional
    public void delete(int id, int userId){
        log.info("delete notation {} for user {}", id, userId);
        weightRepository.delete(id, userId);
    }

    public Notation get(int id, int userId) {
        log.info("get notation {} for user {}", id, userId);
        return weightRepository.get(id, userId);
    }

    public List<Notation> getAll(int userId) {
        log.info("getAll notation for user {}", userId);
        return weightRepository.getAll(userId);
    }
}




