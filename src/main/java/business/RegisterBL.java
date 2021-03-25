package business;

import entity.User;
import repository.UserRepo;
import validators.RegisterValidators;

public class RegisterBL {

    private RegisterValidators rv = new RegisterValidators();
    private UserRepo ur = new UserRepo();
    //Verificam mai intai daca field-urile au fost introduse in mod corect
    public int userRegister(String UUID, String username, String password, String nume, String prenume){

        int registrationValidaton = rv.validateRegistration(username, password, nume, prenume);
        if(registrationValidaton == 1){ // username incorect
            return 1;
        }
        if(registrationValidaton == 2){ //parola incorecta
            return 2;
        }
        if(registrationValidaton == 3){ // nume incorect
            return 3;
        }
        if(registrationValidaton == 4){ // prenume incorect
            return 4;
        }

        // verificam daca userul exista in baza de date, iar daca nu, il adaugam
        if(ur.checkUser(username.toUpperCase())) { // userul exista in baza de date
            return 5;
        }
        else{ // adaugam userul in baza de date
            User user = new User(UUID,"regular",username,password,nume,prenume);
            ur.insertNewUser(user);
            return 0;
        }
    }
}


