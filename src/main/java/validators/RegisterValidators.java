package validators;

public class RegisterValidators {

    public boolean usernameValidator(String username){
        return username.length() < 6;
    }

    public boolean passwordValidator(String password){
        return password.length() < 6;
    }

    public boolean numeValidator(String nume){
        return nume.isEmpty();
    }

    public boolean prenumeValidator(String prenume){
        return prenume.isEmpty();
    }


    public int validateRegistration( String username, String password, String nume, String prenume) {
        if (usernameValidator(username)) { // username incorect
            return 1;
        } else {
            if (passwordValidator(password)) { // parola incorecta
                return 2;
            } else {
                if (numeValidator(nume)) { // nume incorect
                    return 3;
                } else {
                    if (prenumeValidator(prenume)) { // prenume incorect
                        return 4;
                    }
                }
            }
        }
        return 0; // toate datele au fost introduse in mod corect
    }
}
