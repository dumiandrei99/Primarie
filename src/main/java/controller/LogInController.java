package controller;
import business.LogInBL;
import view.AdminGUI.AdminMenuGUI;
import view.LogInGUI;
import view.RegisterGUI;
import view.UserGUI.UserMenuGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController {

    private LogInGUI logInView;
    private RegisterGUI registerView;
    private AdminMenuGUI adminMenuView;
    private UserMenuGUI userMenuGUI;
    private LogInBL logInBL = new LogInBL();

    public LogInController(AdminMenuGUI adminMenuView,LogInGUI logInView, RegisterGUI registerView,UserMenuGUI userMenuGUI){
        this.logInView = logInView;
        this.registerView = registerView;
        this.adminMenuView = adminMenuView;
        this.userMenuGUI = userMenuGUI;
        this.logInView.loginButtonListener(new LogInListener());
        this.logInView.registerButtonListener(new RegisterButtonListener());
    }

    private void deployAdminGUI(){
        adminMenuView.getFrame().show();
        logInView.getFrame().dispose();
    }

    private void deployUserGUI(){
        userMenuGUI.getFrame().show();
        logInView.getFrame().dispose();
    }

    private void loginErrorMessage(){
        logInView.setConnection("Conexiune nereusita! Verificati numele si parola, iar daca nu aveti cont, inregistrati-va!");
    }

    private void deployRegisterGUI(){
        registerView.getFrame().show();
    }
    //butonul de log-in
    class LogInListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            String username = logInView.getEnterUserName().toUpperCase();
            String password = logInView.getEnterPassword();

            // do the business logic
            int connection = logInBL.makeConnection(username,password);

            //update the view
            if (connection == 1){
                deployAdminGUI();
            }

            if(connection == 2){
                deployUserGUI();
            }

            if(connection == 3){
                loginErrorMessage();
            }
        }
    }

    //butonul de register
    class RegisterButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //update the view
            deployRegisterGUI();
        }
    }
}
