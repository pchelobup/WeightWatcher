package ru.alina.to;

import ru.alina.model.Notation;

import java.time.LocalDate;

public class NotationTo {
    private Long id;
    private LocalDate added;
    private String formattedAdded;
    private Double weight;
    private boolean isLower;

    public NotationTo() {
    }

    public NotationTo(Notation notation, boolean isLower) {
        this.id = notation.getId();
        this.added = notation.getAdded();
        this.weight = notation.getWeight();
        this.isLower = isLower;
        this.formattedAdded = String.format("%s-%s-%d", added.getDayOfMonth() > 10 ? added.getDayOfMonth() : "0" + added.getDayOfMonth(), added.getMonthValue() > 10 ? added.getMonthValue() : "0" + added.getMonthValue(), added.getYear());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isLower() {
        return isLower;
    }

    public void setLower(boolean lower) {
        isLower = lower;
    }

    public String getFormattedAdded() {
        return formattedAdded;
    }

    public void setFormattedAdded(String formattedAdded) {
        this.formattedAdded = formattedAdded;
    }

    @Override
    public String toString() {
        return "NotationTo{" +
                "id=" + id +
                ", added=" + added +
                ", weight=" + weight +
                ", isLower=" + isLower +
                '}';
    }
}
