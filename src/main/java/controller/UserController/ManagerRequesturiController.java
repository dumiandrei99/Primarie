package controller.UserController;

import business.ManagerRequesturiBL;
import view.LogInGUI;
import view.UserGUI.ManagerRequesturiGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerRequesturiController {

    private ManagerRequesturiBL managerRequesturiBL = new ManagerRequesturiBL();
    private ManagerRequesturiGUI managerRequesturiView;
    private LogInGUI loginView;

    public ManagerRequesturiController(ManagerRequesturiGUI managerRequesturiView,LogInGUI loginView){
        this.managerRequesturiView = managerRequesturiView;
        this.loginView = loginView;
        managerRequesturiView.adaugaButtonListener(new AdaugaListener());
        managerRequesturiView.stergeButtonListener(new StergeListener());
    }

    private void updateViewAfterInsert(String username){
        String[][] newCereri = managerRequesturiBL.getCereriByUsername(username);
        managerRequesturiView.setCereri(newCereri);
        managerRequesturiView.updateViewAfterInsert();
    }

    private void updateViewAfterDelete(int index,String username){
        String[][] newCereri = managerRequesturiBL.getCereriByUsername(username);
        managerRequesturiView.setCereri(newCereri);
        managerRequesturiView.updateViewAfterDelete(index);
    }

    public class AdaugaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            // do the business logic
            String username = loginView.getEnterUserName();
            String tipCerere = managerRequesturiView.getInputTipCerereField();
            String adresa = managerRequesturiView.getInputAdresaField();
            int index = managerRequesturiBL.adaugaRequest(username.toUpperCase(),tipCerere,adresa);
            // update the view

            if(index == 1){
                managerRequesturiView.setOutputResult("Adresa trebuie sa contina cel putin 6 caractere!");
            }
            else
            {
                if(index == 2){
                    managerRequesturiView.setOutputResult("Tipul cererii trebuie sa contina cel putin 6 caractere!");
                }
                else{
                    if(index == 3){
                        managerRequesturiView.setOutputResult("Tipul cererii nu exista !");
                    }
                    else{
                        if(index == 4){
                            managerRequesturiView.setOutputResult("Exista deja 3 cereri pentru aceasta adresa. Nu se mai pot face !");
                        }
                        else{
                            if(index == 5){
                                managerRequesturiView.setOutputResult("O cerere exista pe aceasta adresa. S-a creat una noua!");
                            }
                            else{
                                if(index == 7){
                                    managerRequesturiView.setOutputResult("Aceasta adresa trebuie introdusa in cont inainte de a crea o cerere!");
                                }
                                else{
                                    managerRequesturiView.setOutputResult("O noua cerere a fost creata pe aceasta adresa cu succes!");
                                    updateViewAfterInsert(username);
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public class StergeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            // do the business logic
            String id = managerRequesturiView.getInputIdField();
            String username = loginView.getEnterUserName();
            int index = managerRequesturiBL.stergeRequest(id,username);
            // update the view
            if(index == -1){
                managerRequesturiView.setOutputResult("Introduceti un numar !");
            }
            else{
                if(index == -2){
                    managerRequesturiView.setOutputResult("Cererea nu exista in baza de date !");
                }
                else{
                    managerRequesturiView.setOutputResult("Cererea a fost stearsa cu succes !");
                    updateViewAfterDelete(index,username);
                }
            }
        }
    }

}
