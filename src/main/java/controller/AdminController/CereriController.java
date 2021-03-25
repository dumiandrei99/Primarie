package controller.AdminController;
import business.CerereBL;
import view.AdminGUI.CereriGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CereriController {

    private CerereBL cereriBL = new CerereBL();
    private CereriGUI cerereView;

    public CereriController(CereriGUI cerereView){
        this.cerereView = cerereView;
        this.cerereView.acceptaButtonListener(new AcceptaListener());
        this.cerereView.stergeButtonListener(new StergeListener());
    }

    private void updateViewAfterRemove(int index){
        String[][] newCereri = cereriBL.getCerere();
        cerereView.setCereri(newCereri);
        cerereView.updateViewAfterDelete(index);
    }

    private void updateViewAfterAccept(int index){
        String[][] newCereri = cereriBL.getCerere();
        cerereView.setCereri(newCereri);
        cerereView.updateViewAfterAccept(index);
    }

    class AcceptaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String idString = cerereView.getInputField();

            // do the business logic
            int index = cereriBL.acceptCerere(idString);

            if(index == -1){
                // update the view
                cerereView.setOutputResult("Introduceti un numar !");
            }
            else
            {
                if(index == -2){
                    //update the view
                    cerereView.setOutputResult("Cererea nu exista in baza de date!");
                }
                else
                {
                    //update the view
                    cerereView.setOutputResult("Cerere acceptata cu succes!");
                    updateViewAfterAccept(index);
                }
            }
        }

    }

    class StergeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String idString = cerereView.getInputField();

            // do the business logic
            int index = cereriBL.removeCerere(idString);

            if(index == -1){
                // update the view
                cerereView.setOutputResult("Introduceti un numar !");
            }
            else
            {
                if(index == -2){
                    //update the view
                    cerereView.setOutputResult("Cererea nu exista in baza de date!");
                }
                else
                {
                    //update the view
                    cerereView.setOutputResult("Cerere stearsa cu succes!");
                    updateViewAfterRemove(index);
                }
            }
        }
    }


}
