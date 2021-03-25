package business;
import repository.UserRepo;


public class LogInBL {

    private UserRepo ur = new UserRepo();

    public int makeConnection(String username, String password){
        // verifica daca numele si parola exista in baza de date / au fost introduse corect
        if(ur.checkUserAndPassword(username,password)){
            if(ur.userType(username).equals("admin")){
                return 1;
            }
            if(ur.userType(username).equals("regular")){
                return 2;
            }
        }
        return 3;
    }
}
