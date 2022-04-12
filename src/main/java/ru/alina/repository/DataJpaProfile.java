package ru.alina.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.alina.model.Profile;

public interface DataJpaProfile extends JpaRepository<Profile, Long> {

}
