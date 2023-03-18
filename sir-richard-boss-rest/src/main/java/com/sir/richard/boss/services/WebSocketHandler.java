package com.sir.richard.boss.services;

public class WebSocketHandler{}
/*
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessionList = new ArrayList<>();
    @Autowired
    private AircraftRepository repository;

    public List<WebSocketSession> getSessionList() {
        return sessionList;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
        System.out.println("Connection established from " + session.toString() +
                " @ " + Instant.now().toString());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        try {
            System.out.println("Message received: '" + message + "', from " +
                    session.toString());

            for (WebSocketSession sessionInList : sessionList) {
                if (sessionInList != session) {
                    sessionInList.sendMessage(message);
                    System.out.println("--> Sending message '" + message + "' to " +
                            sessionInList.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception handling message: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        sessionList.remove(session);
        System.out.println("Connection closed by " + session.toString() +
                " @ " + Instant.now().toString());
    }
}

*/