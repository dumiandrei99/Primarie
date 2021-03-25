package validators;

public class CereriValidator {


    public int isNumber(String num){
        try
        {
            return Integer.parseInt(num);
        }
        catch(Exception e)
        {
            return -1;
        }
    }

    public boolean isAdresaTooShort(String adresa){
        return adresa.length() < 6;
    }

    public boolean isTipCerereTooShort(String tipCerere){
        return tipCerere.length() < 6;
    }
}
