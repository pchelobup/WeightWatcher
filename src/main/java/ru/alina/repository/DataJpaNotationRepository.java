package ru.alina.repository;

import org.springframework.stereotype.Repository;
import ru.alina.model.Notation;

import java.util.List;

@Repository
public class DataJpaNotationRepository implements NotationRepository {
    private final DataJpaUser dataJpaUser;
    private final DataJpaNotation dataJpaNotation;

    public DataJpaNotationRepository(DataJpaUser dataJpaUser, DataJpaNotation dataJpaNotation) {
        this.dataJpaUser = dataJpaUser;
        this.dataJpaNotation = dataJpaNotation;
    }

    @Override
    public Notation save(Notation notation, int userId) {
        if (!notation.isNew() && get(notation.id(), userId) == null) {
            return null;
        }
        notation.setUser(dataJpaUser.getById(userId));
        return dataJpaNotation.save(notation);
    }

    @Override
    public  void delete(int id, int userId) {
        dataJpaNotation.delete(id, userId);
    }

    @Override
    public Notation get(int id, int userId) {
        return dataJpaNotation.findById(id)
                .filter(meal -> meal.getUser().getId() == userId)
                .orElse(null);
    }

    @Override
    public List<Notation> getAll(int userId) {
        return dataJpaNotation.getAll(userId);
    }
}
