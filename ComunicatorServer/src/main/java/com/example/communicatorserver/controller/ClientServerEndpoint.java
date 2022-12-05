package com.example.communicatorserver.controller;

import com.example.communicatorserver.model.InputMessage;
import com.example.communicatorserver.model.OutputMessage;
import com.example.communicatorserver.model.TypeOfMessage;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ServerEndpoint(
    value = "/chat/{from}",
    decoders = InputMessageDecoder.class,
    encoders = OutputMessageEncoder.class)
public class ClientServerEndpoint {
    private Session session;
    private static final ConcurrentMap<String, ClientServerEndpoint> chatEndpoints = new ConcurrentHashMap<>();

    @OnMessage
    public void processMessage(@PathVariable String from, InputMessage inputMessage) {
        // TODO: Add preserving message
        final Date date = new Date();
        if (inputMessage.getTo() == null) {
            broadcastMessage(new OutputMessage(date, from, inputMessage.getMessageBody(), TypeOfMessage.TO_ALL));
        } else {
            sendMessage(chatEndpoints.get(from), new OutputMessage(date, from, inputMessage.getMessageBody(), TypeOfMessage.TO_ONE));
        }
    }

    @OnOpen
    public void establishConnection(Session session, @PathVariable String from) { // this may not work: if there would be issue check if change to @PathParam will solve it
        this.session = session;
        broadcastMessage(new OutputMessage(new Date(), from, from + " connected!", TypeOfMessage.USER_ACTIVE));
        chatEndpoints.put(from, this);
    }

    @OnClose
    public void closeConnection(@PathVariable String from) {
        broadcastMessage(new OutputMessage(new Date(), from, from + " disconnected!", TypeOfMessage.USER_INACTIVE));
        chatEndpoints.remove(from);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // TODO: Handle connection errors
        throwable.printStackTrace();
    }

    private static void sendMessage(ClientServerEndpoint endpoint, OutputMessage message) {
        try { endpoint.session.getBasicRemote().sendObject(message); }
        catch (IOException | EncodeException e) { e.printStackTrace(); }
    }

    private static void broadcastMessage(OutputMessage message) {
        chatEndpoints.values().forEach(endpoint -> { synchronized (endpoint) { sendMessage(endpoint, message); }});
    }
}