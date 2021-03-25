package validators;

public class DocumenteValidators {

    public boolean isDocumentValid(String numeDocument){
        return numeDocument.length() >= 6;
    }

}
