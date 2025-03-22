package com.chan.poker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chan.poker.model.Game;
import com.chan.poker.service.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public Game createGame() {
        return gameService.createGame();
    }
}
