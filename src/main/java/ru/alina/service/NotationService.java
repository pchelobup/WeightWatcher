package ru.alina.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Notation;
import ru.alina.repository.NotationRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NotationService {
    private final NotationRepository weightRepository;

    public NotationService(NotationRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Transactional
    public Notation save(Notation notation, int userId){
        return weightRepository.save(notation, userId);
    }

    @Transactional
    public void delete(int id, int userId){
        weightRepository.delete(id, userId);
    }

    public Notation get(int id, int userId) {
        return weightRepository.get(id, userId);
    }

    public List<Notation> getAll(int userId) {
        return weightRepository.getAll(userId);
    }
}
