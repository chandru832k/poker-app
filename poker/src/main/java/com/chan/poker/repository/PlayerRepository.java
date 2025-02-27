package com.chan.poker.repository;

import com.chan.poker.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    List<Player> findByName(String name);
}
