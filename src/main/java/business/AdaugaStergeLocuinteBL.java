package business;

import entity.Document;
import entity.Locuinte;
import entity.User;
import repository.LocuinteRepo;
import repository.UserRepo;
import validators.AdresaValidator;

import java.util.List;

public class AdaugaStergeLocuinteBL {

    private AdresaValidator av = new AdresaValidator();
    private LocuinteRepo lr = new LocuinteRepo();
    private UserRepo ur = new UserRepo();


    private String getIdByUsername(String username){
        return ur.getIdByUsername(username);
    }


    private int getIndexOfDeletedItem(String adresa,String id){
        List<Locuinte> locuinte = lr.getLocuinteByID(id);
        for(int i = 0 ; i < locuinte.size(); i++){
            if((locuinte.get(i).getAdresa().toUpperCase()).equals(adresa))
                return i;
        }
        return 0;
    }

    private String[][] getUserInfo(String username){
        List<User> results = ur.getUserInfo(username);
        String[][] userInfo = new String[results.size()][3];
        userInfo[0][0] = results.get(0).getId();
        userInfo[0][1] = results.get(0).getNume();
        userInfo[0][2] = results.get(0).getPrenume();

        return userInfo;
    }


    public String[][] getLocuinteByUsername(String username){
        String id = getIdByUsername(username);
        List<Locuinte> results = lr.getLocuinteByID(id);
        String[][] locuinte = new String[results.size()][1];

        for(int i = 0; i < locuinte.length; i++){
            locuinte[i][0] = results.get(i).getAdresa();
        }

        return locuinte;
    }

    public int adaugaLocuinta(String username,String adresa){

        //adresa introdusa a fost prea scurta
        if(!av.lengthVerifier(adresa))
            return -1;

        // adresa introdusa nu exista pentru userul logat
        String id = ur.getIdByUsername(username);
        if(lr.isLocuintaInDB(id,adresa.toUpperCase()))
            return -2;

        // adresa este adaugata//
        String[][] userInfo = getUserInfo(username);
        String UUID = java.util.UUID.randomUUID().toString();
        Locuinte locuinta = new Locuinte(UUID,userInfo[0][0],userInfo[0][1],userInfo[0][2],adresa);
        lr.insertNewLocuinta(locuinta);
        return 3;
    }

    public int stergeLocuinta(String username, String adresa){
        if(!av.lengthVerifier(adresa))
            return -1;
        String id = ur.getIdByUsername(username);
        if(!lr.isLocuintaInDB(id,adresa.toUpperCase()))
            return -2;

        int deletedItemIndex = getIndexOfDeletedItem(adresa.toUpperCase(),id);
        lr.deleteLocuinta(adresa.toUpperCase());
        return deletedItemIndex;
    }
}
