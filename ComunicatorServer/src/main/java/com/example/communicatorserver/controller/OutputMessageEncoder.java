package com.example.communicatorserver.controller;

import com.example.communicatorserver.model.OutputMessage;
import com.google.gson.Gson;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class OutputMessageEncoder implements Encoder.Text<OutputMessage> {
    private static final Gson gson = new Gson();

    @Override
    public String encode(OutputMessage message) {
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}
