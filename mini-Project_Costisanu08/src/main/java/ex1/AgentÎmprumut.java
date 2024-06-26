package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentÎmprumut extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentÎmprumut - started");

        addBehaviour(new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                // Verifică blackboard pentru sarcini noi
                Object task = Blackboard.readFromBlackboard("loan_task");
                if (task != null) {
                    System.out.println("AgentÎmprumut - task found: " + task);
                    // Procesare task...
                    if (task.equals("Check loan status")) {
                        System.out.println("AgentÎmprumut - checking loan status");
                        // Simulează verificarea statusului împrumutului
                        Blackboard.removeFromBlackboard("loan_task"); // Șterge sarcina procesată
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

