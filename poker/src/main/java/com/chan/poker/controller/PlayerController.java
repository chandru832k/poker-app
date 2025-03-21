package com.chan.poker.controller;
import com.chan.poker.dto.PlayerDeduction;
import com.chan.poker.model.Player;
import com.chan.poker.service.PlayerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PostMapping("/{playerId}/place-bet")
    public Player placeBet(@PathVariable String playerId, @RequestParam int amount) {
        return playerService.placeBet(playerId, amount);
    }

    @PostMapping("/{playerId}/deduct-chips")
    public Player deductChipsById(@PathVariable String playerId, @RequestParam int amount) {
        return playerService.deductChipsById(playerId, amount);
    }

    @PostMapping("/{playerId}/take-pot")
    public Player takePot(@PathVariable String playerId, @RequestParam int amount) {
        return playerService.takePot(playerId, amount);
    }

    @PostMapping("/reduce-chips")
    public List<Player> deductChips(@RequestBody List<PlayerDeduction> playerDeductions) {
        return playerService.deductChips(playerDeductions);
    }
}

