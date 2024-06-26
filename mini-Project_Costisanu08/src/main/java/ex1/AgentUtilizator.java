package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentUtilizator extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentUtilizator - started");

        addBehaviour(new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                // Verifică blackboard pentru sarcini noi
                Object task = Blackboard.readFromBlackboard("user_task");
                if (task != null) {
                    System.out.println("AgentUtilizator - task found: " + task);
                    // Procesare task...
                    if (task.equals("Register another user")) {
                        System.out.println("AgentUtilizator - registering another user");
                        Blackboard.writeToBlackboard("user_002", "Jane Doe");
                        Blackboard.removeFromBlackboard("user_task"); // Șterge sarcina procesată
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

