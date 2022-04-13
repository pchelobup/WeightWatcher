package ru.alina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.alina.model.Notation;

import java.util.List;

public interface DataJpaNotation extends JpaRepository<Notation, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Notation n WHERE n.id=:id AND n.user.id=:userId")
    void delete(@Param("id") Long id, @Param("userId") Long userId);

    @Query("SELECT n FROM Notation n WHERE n.user.id=:userId order by n.added desc")
    List<Notation> getAll(@Param("userId") Long userId);
}
