package com.sir.richard.boss;

public class PositionRetriever {}

/*
@Configuration
public class PositionRetriever {
    //@Autowired
    private AircraftRepository repository;
   // @Autowired
    private WebSocketHandler handler;

    //@Bean
    Consumer<List<Aircraft>> retrieveAircraftPositions() {
        return acList -> {
            //repository.deleteAll();

            //repository.saveAll(acList);

            sendPositions();
        };
    }

    private void sendPositions() {
        if (repository.count() > 0) {
            for (WebSocketSession sessionInList : handler.getSessionList()) {
                try {
                    sessionInList.sendMessage(
                            new TextMessage(repository.findAll().toString())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

*/