package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentStatistici extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentStatistici - started");

        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
                // Exemplu: Generează statistici
                Object task = Blackboard.readFromBlackboard("stat_task");
                if (task != null) {
                    System.out.println("AgentStatistici - generating statistics: " + task);
                    // Generare statistici...
                    Blackboard.removeFromBlackboard("stat_task"); // Șterge sarcina procesată
                }
            }
        });
    }
    @Override
    protected void takeDown() {
        System.out.println("AgentBibliotecar - shutting down...");
    }
}
