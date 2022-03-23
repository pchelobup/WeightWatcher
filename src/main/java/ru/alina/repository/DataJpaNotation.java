package ru.alina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Notation;

import java.util.List;

public interface DataJpaNotation extends JpaRepository<Notation, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Notation n WHERE n.id=:id AND n.user.id=:userId")
    void delete(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT n FROM Notation n WHERE n.user.id=:userId")
    List<Notation> getAll(@Param("userId") int userId);
}