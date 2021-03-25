package start;

import controller.AdminController.AdaugaStergeDocumenteController;
import controller.AdminController.AdminMenuController;
import controller.AdminController.CereriController;
import controller.LogInController;
import controller.RegisterController;
import controller.UserController.AdaugaStergeLocuinteController;
import controller.UserController.ManagerRequesturiController;
import controller.UserController.UserMenuController;
import view.AdminGUI.AdaugaStergeDocumenteGUI;
import view.AdminGUI.AdminMenuGUI;
import view.AdminGUI.CereriGUI;
import view.LogInGUI;
import view.RegisterGUI;
import view.UserGUI.AdaugaStergeLocuinteGUI;
import view.UserGUI.ListaCereriGUI;
import view.UserGUI.ManagerRequesturiGUI;
import view.UserGUI.UserMenuGUI;

public class ApplicationStart {

    public static void main(String[] args) {

        LogInGUI logInView = new LogInGUI();
        RegisterGUI registerView = new RegisterGUI();
        AdminMenuGUI adminMenuView = new AdminMenuGUI();
        UserMenuGUI userMenuGUI = new UserMenuGUI();
        AdaugaStergeDocumenteGUI adaugaDocView = new AdaugaStergeDocumenteGUI();
        CereriGUI cerereView = new CereriGUI();
        AdaugaStergeLocuinteGUI adaugaStergeLocuinteView = new AdaugaStergeLocuinteGUI();
        ManagerRequesturiGUI managerRequesturiView = new ManagerRequesturiGUI();
        ListaCereriGUI listaCereriView = new ListaCereriGUI();

        new LogInController(adminMenuView,logInView,registerView,userMenuGUI);
        new RegisterController(registerView);
        new AdminMenuController(adminMenuView,adaugaDocView,cerereView);
        new AdaugaStergeDocumenteController(adaugaDocView);
        new CereriController(cerereView);
        new UserMenuController(logInView,userMenuGUI,adaugaStergeLocuinteView,managerRequesturiView,listaCereriView);
        new AdaugaStergeLocuinteController(adaugaStergeLocuinteView,logInView);
        new ManagerRequesturiController(managerRequesturiView,logInView);
    }
}
