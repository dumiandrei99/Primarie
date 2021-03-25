package validators;

public class AdresaValidator {

    public boolean lengthVerifier(String adresa){
        return adresa.length() >= 6;
    }
}
