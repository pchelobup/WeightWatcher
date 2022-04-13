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
    private final NotationRepository notationRepository;

    public NotationService(NotationRepository weightRepository) {
        this.notationRepository = weightRepository;
    }

    @Transactional
    public Notation save(Notation notation, Long userId){
        log.info("save {} for user {}", notation, userId);
        return notationRepository.save(notation, userId);
    }

    @Transactional
    public void delete(Long id, Long userId){
        log.info("delete notation {} for user {}", id, userId);
        notationRepository.delete(id, userId);
    }

    public Notation get(Long id, Long userId) {
        log.info("get notation {} for user {}", id, userId);
        return notationRepository.get(id, userId);
    }

    public List<Notation> getAll(Long userId) {
        log.info("getAll notation for user {}", userId);
        return notationRepository.getAll(userId);
    }
}




