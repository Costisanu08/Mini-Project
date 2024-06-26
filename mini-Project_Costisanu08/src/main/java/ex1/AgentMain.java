package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.wrapper.ControllerException;

public class AgentMain extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentMain - started");

        // Trimite sarcini periodice agenților
        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
                // Coordonează și trimite sarcini către agenți
                Blackboard.writeToBlackboard("librarian_task", "Update catalog with new books");
                Blackboard.writeToBlackboard("user_task", "Register another user");
                Blackboard.writeToBlackboard("loan_task", "Check loan status");
                Blackboard.writeToBlackboard("search_book", "book_456");
                Blackboard.writeToBlackboard("notification", "Send reminder notice");
                Blackboard.writeToBlackboard("stat_task", "Generate usage statistics");
                System.out.println("AgentMain - tasks sent to respective agents");
            }
        });

        // Oprește toți agenții după 30 de secunde
        addBehaviour(new WakerBehaviour(this, 30000) {
            @Override
            protected void onWake() {
                System.out.println("AgentMain - shutting down...");
                myAgent.doDelete();
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("AgentMain - terminating platform...");
        try {
            // Oprește platforma JADE
            getContainerController().getPlatformController().kill();
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }
}
