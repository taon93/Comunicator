package com.example.communicatorserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputMessage {
    private Date timestamp;
    private String sender;
    private String messageBody;
    private TypeOfMessage typeOfMessage;
}

