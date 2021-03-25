package business;

import entity.Cerere;
import repository.CerereRepo;
import validators.CereriValidator;

import java.util.List;

public class CerereBL {

    private CereriValidator cv = new CereriValidator();
    private CerereRepo cr = new CerereRepo();


    public String[][] getCerere(){

        List<Cerere> results = cr.getCerere();
        String[][] cereri = new String[results.size()][4];
        for(int i = 0; i < results.size(); i++){
            cereri[i][0] = Integer.toString(results.get(i).getIdCerere());
            cereri[i][1] = results.get(i).getTipCerere();
            cereri[i][2] = results.get(i).getAdresa();
            cereri[i][3] = results.get(i).getAprobare();
        }
        return cereri;
    }

    public int acceptCerere(String idString){
        int id= cv.isNumber(idString);
        if(id == -1)
            return -1;

        //cererea nu exista in baza de date
        if(!cr.isCerereInDB(id))
            return -2;

        int updatedItemIndex = getIndexOfUpdatedItem(id);
        cr.updateOnAccept(id);
        return updatedItemIndex;
    }

    private int getIndexOfUpdatedItem(int id){
        List<Cerere> cereri = cr.getCerere();
        for(int i = 0 ; i < cereri.size(); i++){
            if(cereri.get(i).getIdCerere() == id)
                return i;
        }
        return 0;
    }

    public int removeCerere(String idString){
        int id= cv.isNumber(idString);

        // nu s-a introdus un numar
        if(id == -1)
            return -1;

        //cererea nu exista in baza de date
        if(!cr.isCerereInDB(id))
            return -2;

        int deletedItemIndex = getIndexOfUpdatedItem(id);
        cr.deleteCerere(id);
        return deletedItemIndex;
    }
}
