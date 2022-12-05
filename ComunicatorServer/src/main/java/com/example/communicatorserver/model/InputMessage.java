package com.example.communicatorserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InputMessage {
    String to; // optional: if lacking - broadcast
    String messageBody;
}
