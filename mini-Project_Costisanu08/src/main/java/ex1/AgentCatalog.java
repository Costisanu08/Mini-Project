package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentCatalog extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentCatalog - started");

        addBehaviour(new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                // Exemplu: Caută o carte în catalog
                String book = (String) Blackboard.readFromBlackboard("search_book");
                if (book != null) {
                    System.out.println("AgentCatalog - book found: " + book);
                    // Procesare căutare...
                    Blackboard.removeFromBlackboard("search_book"); // Șterge sarcina procesată
                }
            }
        });
    }
    @Override
    protected void takeDown() {
        System.out.println("AgentBibliotecar - shutting down...");
    }
}

