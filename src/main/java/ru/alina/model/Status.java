package ru.alina.model;

public enum Status {
    ACTIVE, NOT_ACTIVE, DELETED;

    public boolean isActive() {
        return this.name().equals("ACTIVE");
    }
}
