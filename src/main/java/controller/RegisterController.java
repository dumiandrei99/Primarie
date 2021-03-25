package controller;
import business.RegisterBL;
import repository.UserRepo;
import view.RegisterGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private RegisterGUI registerView;
    private RegisterBL registerBL = new RegisterBL();

    public RegisterController(RegisterGUI registerView){
        this.registerView = registerView;
        this.registerView.inregistrareButtonListener(new InregistrareButtonListener());

    }

    private void incorrectUsernameMessage(){
        registerView.setVerificareInregistrare("Username-ul trebuie sa aiba cel putin 6 caractere !");
        registerView.emptyPasswordField();
    }
    private void incorrectPasswordMessage(){
        registerView.setVerificareInregistrare("Parola trebuie sa aiba cel putin 6 caractere !");
        registerView.emptyPasswordField();
    }

    private void incorrectNumeMessage(){
        registerView.setVerificareInregistrare("Comlpetati numele !");
        registerView.emptyPasswordField();
    }

    private void incorrectPrenumeMessage(){
        registerView.setVerificareInregistrare("Completati prenumele !");
        registerView.emptyPasswordField();
    }

    private void existingUserMessage(){
        registerView.setVerificareInregistrare("Username-ul exista deja! Introduceti unul diferit.");
        registerView.emptyPasswordField();
    }

    private void successfulRegistrationMessage(){
        registerView.setVerificareInregistrare("Inregistrarea s-a facut cu succes !");
    }

     class InregistrareButtonListener implements ActionListener{

        @Override

        public void actionPerformed(ActionEvent e) {

            // get the data input from the user
            String username = registerView.getEnterUsername();
            String password = registerView.getEnterPassword();
            String nume = registerView.getEnterNume();
            String prenume = registerView.getEnterPrenume();
            String UUID = java.util.UUID.randomUUID().toString();

            // do the business logic
            int register = registerBL.userRegister(UUID,username,password,nume,prenume);

            // update the view
            if(register == 1){
                incorrectUsernameMessage();
            }

            if(register == 2){
                incorrectPasswordMessage();
            }

            if(register == 3){
                incorrectNumeMessage();
            }

            if(register == 4){
                incorrectPrenumeMessage();
            }

            if(register == 5){
                existingUserMessage();
            }

            if(register == 0){
                successfulRegistrationMessage();
            }
        }
    }
}
