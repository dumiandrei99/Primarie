package controller.AdminController;
import business.AdaugaStergeDocumenteBL;
import repository.DocumentRepo;
import view.AdminGUI.AdaugaStergeDocumenteGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugaStergeDocumenteController {

    private AdaugaStergeDocumenteBL adaugaStergeDocumenteBL = new AdaugaStergeDocumenteBL();
    private AdaugaStergeDocumenteGUI adaugaView;

    public AdaugaStergeDocumenteController(AdaugaStergeDocumenteGUI adaugaDocView){
        this.adaugaView = adaugaDocView;
        this.adaugaView.adaugaButtonListener(new AdaugaListener());
        this.adaugaView.stergeButtonListener(new StergeListener());
    }


    private void updateViewAfterInsert(){
        String[][] newDocs = adaugaStergeDocumenteBL.getAvailableDocs();
        adaugaView.setAvailableDocs(newDocs);
        adaugaView.updateViewAfterInsert();

    }

    private void updateViewAfterDelete(int index){
        String[][] newDocs = adaugaStergeDocumenteBL.getAvailableDocs();
        adaugaView.setAvailableDocs(newDocs);
        adaugaView.updateViewAfterDelete(index);
    }
    class AdaugaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // do the business logic
             String tipDocument = adaugaView.getInputField();
             int index = adaugaStergeDocumenteBL.insertDocument(tipDocument);

             // daca documentul este valid se adauga in tabel si se updateaza viewul
             if(index == 0){
                 // update the view
                 adaugaView.setOutputResult("Documentul a fost adaugat cu succes!");
                 updateViewAfterInsert();
             }
             else{
                 if(index == -1){
                     //update the view
                     adaugaView.setOutputResult("Numele trebuie sa aiba minim 6 caractere!");
                 }
                 else{
                     if(index == -2){
                         //update the view
                         adaugaView.setOutputResult("Documentul exista deja in baza de date !");
                     }
                 }
             }
        }
    }

    class StergeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String tipDocument = adaugaView.getInputField();

            //do the business logic
            int index = adaugaStergeDocumenteBL.deleteDocument(tipDocument);

            // daca documentul este valid se sterge din baza de date
            if(index == -1){
                //update the view
                adaugaView.setOutputResult("Numele trebuie sa aiba minim 6 caractere!");
            }
            else{
                if(index == -2){
                    //update the view
                    adaugaView.setOutputResult("Documentul nu exista in baza de date !");
                }
                else{
                    // update the view
                    updateViewAfterDelete(index);
                    adaugaView.setOutputResult("Documentul a fost sters cu succes!");
                }
            }
        }
    }
}
