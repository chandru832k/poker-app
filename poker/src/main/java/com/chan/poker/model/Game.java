package com.chan.poker.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chan.poker.enums.GameStatus;

import lombok.Data;

@Data
@Document(collection = "game")
public class Game {
    @Id
    private String id;
    private GameStatus status; // e.g., "WAITING", "IN_PROGRESS", "COMPLETED"
    private List<String> playerIds;
    private int pot;
    private Map<String, Integer> leaderboard;
}