package com.chan.poker.dto;

import lombok.Data;

@Data
public class PlayerDeduction {
    private String playerId;
    private int amount;
}