package business;

import entity.Cerere;
import entity.Locuinte;
import repository.CerereRepo;
import repository.DocumentRepo;
import repository.LocuinteRepo;
import repository.UserRepo;
import validators.CereriValidator;

import java.util.Date;
import java.util.List;

public class ManagerRequesturiBL {
    private UserRepo ur = new UserRepo();
    private CerereRepo cr = new CerereRepo();
    private LocuinteRepo lr = new LocuinteRepo();
    private DocumentRepo dr = new DocumentRepo();
    private CereriValidator cv = new CereriValidator();

    private String getIdByUsername(String username){
        return ur.getIdByUsername(username.toUpperCase());
    }
    private String getNumeByUsername(String username){return ur.getNameByUsername(username);}
    private String getPrenumeByUsername(String username){return ur.getPrenumeByUsername(username);}


    private int getIndexOfDeletedItem(int id,String userId){
        List<Cerere> cerere = cr.getCerereByID(userId);
        for(int i = 0 ; i < cerere.size(); i++){
            if(cerere.get(i).getIdCerere() == id )
                return i;
        }
        return 0;
    }


    public String[][] getCereriByUsername(String username){
        String id = getIdByUsername(username);
        List<Cerere> results = cr.getCerereByID(id);
        String[][] cereri = new String[results.size()][6];

        for(int i = 0; i < cereri.length; i++){
            cereri[i][0] = Integer.toString(results.get(i).getIdCerere());
            cereri[i][1] = results.get(i).getTipCerere();
            cereri[i][2] = results.get(i).getData();
            cereri[i][3] = results.get(i).getAdresa();
            cereri[i][4] = Integer.toString(results.get(i).getNumarCereri());
            cereri[i][5] = results.get(i).getAprobare();
        }

        return cereri;
    }

    public int adaugaRequest(String username, String tipCerere,String adresa){
        String id = getIdByUsername(username);
        String nume = getNumeByUsername(username);
        String prenume = getPrenumeByUsername(username);

        // daca field-ul adresa e prea scurt
        if(cv.isAdresaTooShort(adresa))
            return 1;

        //daca fieldul tip cerere e prea scurt
        if(cv.isTipCerereTooShort(tipCerere))
            return 2;

        // daca documentul nu exista in baza de date
        if(!dr.isDocumentInDB(tipCerere.toUpperCase())){
            return 3;
        }

        if(!lr.isLocuintaInDB(id,adresa.toUpperCase())){
            return 7;
        }

        // daca cererea exista in baza de date, se updateaza numarul cererii
        if(cr.isCerereInDB(id,adresa.toUpperCase(),tipCerere.toUpperCase())){
            int numarCereri = cr.getNumarCereri(id,adresa.toUpperCase());
            System.out.println(adresa);
            System.out.println(numarCereri);
            if(numarCereri >= 3)
                return 4;
            else{
                numarCereri++;
                System.out.println(numarCereri);
                cr.updateNumarCereri(id,adresa.toUpperCase(),numarCereri);
                return 5;
            }
        }

        Date date = new Date();
        Cerere cerere = new Cerere(id,tipCerere.toLowerCase(),date.toString(),nume,prenume,adresa,1,"pending");
        cr.insertNewCerere(cerere);
        return 6;
    }

    public int stergeRequest(String idString,String username){

        int id = cv.isNumber(idString);
        String idUser = getIdByUsername(username);
        if(id == -1)
            return -1;

        //cererea nu exista in baza de date
        if(!cr.isCerereInDB(id,idUser))
            return -2;

        int deletedItemIndex = getIndexOfDeletedItem(id,idUser);
        cr.deleteCerere(id);
        return deletedItemIndex;
    }
}
