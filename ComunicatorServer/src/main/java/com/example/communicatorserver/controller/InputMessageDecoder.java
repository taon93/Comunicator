package com.example.communicatorserver.controller;

import com.example.communicatorserver.model.InputMessage;
import com.google.gson.Gson;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class InputMessageDecoder implements Decoder.Text<InputMessage> {

    private static final Gson gson = new Gson();

    @Override
    public InputMessage decode(String s) {
        return gson.fromJson(s, InputMessage.class);
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
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
