package com.chan.poker.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chan.poker.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="Transaction")
public class Transaction {
    @Id
    private String id;
    private String playerId;
    private int amount;
    private TransactionType type;
    private Date timestamp;
}
