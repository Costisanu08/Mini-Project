package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentBibliotecar extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentBibliotecar - started");

        addBehaviour(new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                // Verifică blackboard pentru sarcini noi
                Object task = Blackboard.readFromBlackboard("librarian_task");
                if (task != null) {
                    System.out.println("AgentBibliotecar - task found: " + task);
                    // Procesare task...
                    if (task.equals("Update catalog with new books")) {
                        System.out.println("AgentBibliotecar - updating catalog with new books");
                        Blackboard.writeToBlackboard("book_456", "Advanced Programming in JADE");
                        Blackboard.removeFromBlackboard("librarian_task"); // Șterge sarcina procesată
                    }
                }
            }
        });
    }
    @Override
    protected void takeDown() {
        System.out.println("AgentBibliotecar - shutting down...");
    }
}
