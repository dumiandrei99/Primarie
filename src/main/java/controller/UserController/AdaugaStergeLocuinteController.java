package controller.UserController;

import business.AdaugaStergeLocuinteBL;
import view.LogInGUI;
import view.UserGUI.AdaugaStergeLocuinteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugaStergeLocuinteController {

    private LogInGUI loginView;
    private AdaugaStergeLocuinteBL adaugaStergeLocuinteBL = new AdaugaStergeLocuinteBL();
    private AdaugaStergeLocuinteGUI adaugaStergeLocuinteView;

    public AdaugaStergeLocuinteController(AdaugaStergeLocuinteGUI adaugaStergeLocuinteView,LogInGUI logInView){
        this.adaugaStergeLocuinteView = adaugaStergeLocuinteView;
        this.loginView = logInView;
        adaugaStergeLocuinteView.adaugaButtonListener(new AdaugaListener());
        adaugaStergeLocuinteView.stergeButtonListener(new StergeListener());
    }

    private void updateViewAfterDelete(int index, String username){
        String[][] newLocuinte = adaugaStergeLocuinteBL.getLocuinteByUsername(username);
        adaugaStergeLocuinteView.setLocuinte(newLocuinte);
        adaugaStergeLocuinteView.updateViewAfterDelete(index);
    }
    private void updateViewAfterInsert(String username){
        String[][] newLocuinte = adaugaStergeLocuinteBL.getLocuinteByUsername(username);
        adaugaStergeLocuinteView.setLocuinte(newLocuinte);
        adaugaStergeLocuinteView.updateViewAfterInsert();
    }

    public class AdaugaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // do the business logic
            String adresa = adaugaStergeLocuinteView.getInputField();
            String username = loginView.getEnterUserName().toUpperCase();
            int index = adaugaStergeLocuinteBL.adaugaLocuinta(username,adresa);


            // update the view
            if(index == -1){
                //update the view
                adaugaStergeLocuinteView.setOutputResult("Adresa trebuie sa aiba minim 6 caractere!");

            }
            else
            {
                if(index == -2){
                    // update the view
                    adaugaStergeLocuinteView.setOutputResult("Adresa este deja in baza de date!");
                }
                else
                {
                    adaugaStergeLocuinteView.setOutputResult("Adresa adaugata cu succes!");
                    updateViewAfterInsert(username);
                }

            }
        }
    }

    public class StergeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // do the business logic
            String adresa = adaugaStergeLocuinteView.getInputField();
            String username = loginView.getEnterUserName().toUpperCase();
            int index = adaugaStergeLocuinteBL.stergeLocuinta(username,adresa);


            // update the view
            if(index == -1){
                //update the view
                adaugaStergeLocuinteView.setOutputResult("Adresa trebuie sa aiba minim 6 caractere!");

            }
            else
            {
                if(index == -2){
                    // update the view
                    adaugaStergeLocuinteView.setOutputResult("Adresa nu exista in baza de date!");
                }
                else
                {
                    adaugaStergeLocuinteView.setOutputResult("Adresa stearsa cu succes!");
                    updateViewAfterDelete(index,username);
                }
            }
        }
    }


}
