package com.chan.poker.service;

import com.chan.poker.dto.PlayerDeduction;
import com.chan.poker.enums.TransactionType;
import com.chan.poker.model.Player;
import com.chan.poker.model.Transaction;
// import com.chan.poker.model.Transaction;
import com.chan.poker.repository.PlayerRepository;
import com.chan.poker.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TransactionRepository transactionRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player placeBet(String playerId, int amount) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        if (player.getChips() < amount) {
            throw new RuntimeException("Insufficient chips to place the bet");
        }
        player.setChips(player.getChips() - amount);
        playerRepository.save(player);

        Transaction transaction = new Transaction();
        transaction.setPlayerId(playerId);
        transaction.setAmount(-amount);
        transaction.setType(TransactionType.BET);
        transactionRepository.save(transaction);
        return player;
    }

    public Player deductChipsById(String playerId, int amount) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        if (player.getChips() < amount) {
            throw new RuntimeException("Chip balance is lower than amount");
        }
        player.setChips(player.getChips() - amount);
        playerRepository.save(player);

        Transaction transaction = new Transaction();
        transaction.setPlayerId(playerId);
        transaction.setAmount(-amount);
        transaction.setType(TransactionType.LOSE);
        transactionRepository.save(transaction);
        return player;
    }

    public Player takePot(String playerId, int amount) {
        Player player = playerRepository.findById(playerId)
        .orElseThrow(() -> new RuntimeException("Player not found"));
        player.setChips(player.getChips() + amount);
        Transaction transaction = new Transaction();
        transaction.setPlayerId(playerId);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.WIN);
        return player;
    }

    public List<Player> deductChips(List<PlayerDeduction> playerDeductions) {
         List<Player> updatedPlayers = new ArrayList<>();

        for (PlayerDeduction deduction : playerDeductions) {
            String playerId = deduction.getPlayerId();
            int amount = deduction.getAmount();

            try {
                Player updatedPlayer = deductChipsById(playerId, amount);
                updatedPlayers.add(updatedPlayer);
            } catch (RuntimeException e) {
                System.err.println("Failed to deduct chips from player " + playerId + ": " + e.getMessage());
            }
        }
        return updatedPlayers;
    }
}
