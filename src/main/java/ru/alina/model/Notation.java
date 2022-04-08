package ru.alina.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Notation extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate added;
    private Double weight;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getAdded() {
        return added;
    }

    public void setAdded(LocalDate added) {
        this.added = added;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Notation() {
    }

    public Notation(LocalDate added, Double weight) {
        this.added = added;
        this.weight = weight;
    }

    public Notation(Long id, User user, LocalDate added, Double weight) {
        super(id);
        this.user = user;
        this.added = added;
        this.weight = weight;
    }

    public Notation(Long id, LocalDate added, Double weight) {
        super(id);
        this.added = added;
        this.weight = weight;
    }

    public Notation(User user, LocalDate added, Double weight) {
        this.user = user;
        this.added = added;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Notation{" +
                "id='" + getId() + '\'' +
                "added=" + added +
                ", weight=" + weight +
                '}';
    }


}
