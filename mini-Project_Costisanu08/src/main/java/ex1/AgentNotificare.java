package ex1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AgentNotificare extends Agent {
    @Override
    protected void setup() {
        System.out.println("AgentNotificare - started");

        addBehaviour(new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                // Exemplu: Trimite notificare de întârziere
                Object notification = Blackboard.readFromBlackboard("notification");
                if (notification != null) {
                    System.out.println("AgentNotificare - notification sent: " + notification);
                    // Procesare notificare...
                    if (notification.equals("Send reminder notice")) {
                        System.out.println("AgentNotificare - sending reminder notice");
                        // Simulează trimiterea notificării
                        Blackboard.removeFromBlackboard("notification"); // Șterge sarcina procesată
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

