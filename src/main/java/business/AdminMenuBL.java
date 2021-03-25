package business;
import entity.User;
import repository.UserRepo;


import java.util.List;

public class AdminMenuBL {

    private UserRepo ur = new UserRepo();

    public String[][] getAllUsers(){

        List<User> results = ur.allUsers();
        String [][] users = new String[results.size()][4];

        for(int i = 0 ; i < results.size(); i++){
            users[i][0] = results.get(i).getId();
            users[i][1] = results.get(i).getUsername();
            users[i][2] = results.get(i).getNume();
            users[i][3] = results.get(i).getPrenume();
        }
        return users;
    }

}
