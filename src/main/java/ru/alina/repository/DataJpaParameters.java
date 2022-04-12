package ru.alina.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.alina.model.Parameters;

public interface DataJpaParameters extends JpaRepository<Parameters, Long> {

}
