package com.chan.poker.repository;

import com.chan.poker.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    /**
     * Find all transactions for a specific player.
     *
     * @param playerId The ID of the player.
     * @return A list of transactions for the player.
     */
    List<Transaction> findByPlayerId(String playerId);

    /**
     * Find all transactions of a specific type for a player.
     *
     * @param playerId The ID of the player.
     * @param type     The type of transaction (e.g., "BUY_IN", "BET", "WIN", "LOSS").
     * @return A list of transactions matching the type for the player.
     */
    List<Transaction> findByPlayerIdAndType(String playerId, String type);

    /**
     * Find all transactions of a specific type.
     *
     * @param type The type of transaction (e.g., "BUY_IN", "BET", "WIN", "LOSS").
     * @return A list of transactions matching the type.
     */
    List<Transaction> findByType(String type);
}