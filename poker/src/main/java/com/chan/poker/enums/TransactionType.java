package com.chan.poker.enums;


public enum TransactionType {
    BUY_IN("buy_in"),
    BET("bet"),
    WIN("win"),
    LOSE("lose");

    private final String value;

    TransactionType(String type) {
        this.value = type;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}