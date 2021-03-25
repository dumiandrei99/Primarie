package controller.UserController;

import business.AdaugaStergeDocumenteBL;
import business.AdaugaStergeLocuinteBL;
import business.ManagerRequesturiBL;
import view.LogInGUI;
import view.UserGUI.AdaugaStergeLocuinteGUI;
import view.UserGUI.ListaCereriGUI;
import view.UserGUI.ManagerRequesturiGUI;
import view.UserGUI.UserMenuGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenuController {

    private LogInGUI logInView;
    private AdaugaStergeLocuinteGUI adaugaStergeLocuinteView;
    private ManagerRequesturiGUI managerRequesturiView;
    private ListaCereriGUI listaCereriView;
    private AdaugaStergeLocuinteBL adaugaStergeLocuinteBL = new AdaugaStergeLocuinteBL();
    private ManagerRequesturiBL managerRequesturiBL = new ManagerRequesturiBL();
    private AdaugaStergeDocumenteBL adaugaStergeDocumenteBL = new AdaugaStergeDocumenteBL();

    private boolean initLocuinte = false;
    private boolean initManager = false;
    private boolean initLista = false;

    public UserMenuController(LogInGUI logInView,UserMenuGUI userMenuView, AdaugaStergeLocuinteGUI adaugaStergeLocuinteView, ManagerRequesturiGUI managerRequesturiView, ListaCereriGUI listaCereriView){
        this.logInView = logInView;
        this.listaCereriView = listaCereriView;
        this.adaugaStergeLocuinteView = adaugaStergeLocuinteView;
        this.managerRequesturiView = managerRequesturiView;
        userMenuView.requestButtonListener(new RequestButtonListener());
        userMenuView.adaugaStergeLocuinteButtonListener(new AdaugaStergeListener());
    }

    private void deployManagerRequesturiGUI(String[][] cereri){
        managerRequesturiView.setCereri(cereri);
        if(!initManager){
            managerRequesturiView.initialize();
            initManager = true;
        }
        managerRequesturiView.getFrame().show();
    }

    private void deployListaCereriGUI(String[][] documente){
        listaCereriView.setAvailableDocs(documente);
        if(!initLista){
            listaCereriView.initialize();
            initLista = true;
        }
        listaCereriView.getFrame().show();
    }

    private void deployAdaugaStergeLocuinteGUI(String[][] locuinte){
        adaugaStergeLocuinteView.setLocuinte(locuinte);
        if(!initLocuinte){
            adaugaStergeLocuinteView.initialize();
            initLocuinte = true;
        }
        adaugaStergeLocuinteView.getFrame().show();
    }

    class RequestButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = logInView.getEnterUserName().toUpperCase();
            String[][] cereri = managerRequesturiBL.getCereriByUsername(username);
            String[][] documente = adaugaStergeDocumenteBL.getAvailableDocs();
            deployManagerRequesturiGUI(cereri);
            deployListaCereriGUI(documente);
        }
    }

    class AdaugaStergeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = logInView.getEnterUserName().toUpperCase();
            String[][] locuinte = adaugaStergeLocuinteBL.getLocuinteByUsername(username);
            deployAdaugaStergeLocuinteGUI(locuinte);
        }
    }
}
