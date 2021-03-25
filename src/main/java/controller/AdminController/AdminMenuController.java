package controller.AdminController;
import business.AdaugaStergeDocumenteBL;
import business.AdminMenuBL;
import business.CerereBL;
import view.AdminGUI.AdaugaStergeDocumenteGUI;
import view.AdminGUI.AdminMenuGUI;
import view.AdminGUI.CereriGUI;
import view.AdminGUI.UtilizatoriGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuController {

    private AdaugaStergeDocumenteGUI adaugaView;
    private CereriGUI cereriView;
    private AdaugaStergeDocumenteBL adaugaStergeDocumenteBL = new AdaugaStergeDocumenteBL();
    private CerereBL cerereBL = new CerereBL();
    private AdminMenuBL adminBL = new AdminMenuBL();
    private boolean initAdauga = false;
    private boolean initCereri = false;


    public AdminMenuController(AdminMenuGUI adminMenView, AdaugaStergeDocumenteGUI adaugaView, CereriGUI cereriView) {
        this.adaugaView = adaugaView;
        this.cereriView = cereriView;
        adminMenView.vizualizareUtilizatoriButtonListener(new VizualizareListener());
        adminMenView.requestButtonListener(new RequestListener());
        adminMenView.documenteButtonListener(new DocumenteListener());
    }


    private void deployUtilizatoriGUI(String[][] users){
        UtilizatoriGUI utilizatoriView = new UtilizatoriGUI(users);
        utilizatoriView.getFrame().show();
    }

    private void deployCerereGUI(String[][] cereri){
        cereriView.setCereri(cereri);
        if(!initCereri){
            cereriView.initialize();
            initCereri = true;
        }
        cereriView.getFrame().show();
    }

    private void deployAdaugaGUI(String[][] availableDocs){
        adaugaView.setAvailableDocs(availableDocs);
        // initializam prima oara view-ul pentru fereastra Adauga / Sterge documente
        if(!initAdauga) {
            adaugaView.initialize();
            initAdauga = true;
        }
        adaugaView.getFrame().show();
    }
    class VizualizareListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //do the business logic
            String [][] users = adminBL.getAllUsers();
            // update the view
            deployUtilizatoriGUI(users);
        }
    }

    class RequestListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String [][] cereri = cerereBL.getCerere();
            deployCerereGUI(cereri);
        }
    }

    class DocumenteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // do the business logic
            String[][] availableDocs = adaugaStergeDocumenteBL.getAvailableDocs();
            //update the view
            deployAdaugaGUI(availableDocs);
        }
    }
}
