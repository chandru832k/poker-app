package com.chan.poker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "player")
public class Player {
    @Id
    private String id;
    private String name;
    private int chips;
}
