package com.example.comunicatorserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Date timestamp;
    private String sender;
    private String receiver;
    private String messageBody;
}
