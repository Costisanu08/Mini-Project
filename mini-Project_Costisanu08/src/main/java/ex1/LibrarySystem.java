package ex1;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class LibrarySystem {
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        ContainerController cc = rt.createMainContainer(p);

        try {
            // Inițializare agenți
            AgentController librarianAgent = cc.createNewAgent("AgentBibliotecar", AgentBibliotecar.class.getName(), null);
            AgentController userAgent = cc.createNewAgent("AgentUtilizator", AgentUtilizator.class.getName(), null);
            AgentController loanAgent = cc.createNewAgent("AgentÎmprumut", AgentÎmprumut.class.getName(), null);
            AgentController catalogAgent = cc.createNewAgent("AgentCatalog", AgentCatalog.class.getName(), null);
            AgentController notificationAgent = cc.createNewAgent("AgentNotificare", AgentNotificare.class.getName(), null);
            AgentController statisticsAgent = cc.createNewAgent("AgentStatistici", AgentStatistici.class.getName(), null);
            AgentController mainAgent = cc.createNewAgent("AgentMain", AgentMain.class.getName(), null);

            // Start agenți
            librarianAgent.start();
            userAgent.start();
            loanAgent.start();
            catalogAgent.start();
            notificationAgent.start();
            statisticsAgent.start();
            mainAgent.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}

