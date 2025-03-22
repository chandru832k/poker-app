package com.chan.poker.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.chan.poker.enums.GameStatus;
import com.chan.poker.model.Game;
import com.chan.poker.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public Game createGame() {
        Game game = new Game();
        game.setStatus(GameStatus.WAITING);
        game.setPot(0);
        game.setLeaderboard(new HashMap<>());
        return gameRepository.save(game);
    }
    
}
