package com.chan.poker.enums;

public enum GameStatus {
    WAITING("waiting"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed");

    private final String value;

    GameStatus(String status) {
        this.value = status;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}