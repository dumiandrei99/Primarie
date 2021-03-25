package business;

import entity.Document;
import repository.DocumentRepo;
import validators.DocumenteValidators;

import java.util.List;

public class AdaugaStergeDocumenteBL {

    private DocumenteValidators dv = new DocumenteValidators();
    private DocumentRepo dr = new DocumentRepo();

    private int getIndexOfDeletedItem(String numeDocument){
        List<Document> docs = dr.getDocumente();
        for(int i = 0 ; i < docs.size(); i++){
            if((docs.get(i).getTipDocument().toUpperCase()).equals(numeDocument))
                return i;
        }
        return 0;
    }
    public String[][] getAvailableDocs(){

        List<Document> results = dr.getDocumente();
        String[][] docs = new String[results.size()][1];
        for(int i = 0; i < results.size(); i++){
            docs[i][0] = results.get(i).getTipDocument();
        }

        return docs;
    }

    public int insertDocument(String documentName){
        String UUID = java.util.UUID.randomUUID().toString();
        Document document = new Document(UUID,documentName.toLowerCase());

        // daca documentul nu are cel putin 6 caractere, se returneaza un mesaj de eroare
        if(!dv.isDocumentValid(documentName))
            return -1;
        // daca documentul se afla in baza de date, se returneaza un mesaj de eroare
        if(dr.isDocumentInDB(documentName.toUpperCase()))
            return -2;
        // daca documentul este valid, se introduce in baza de date
        dr.insertNewDocument(document);
        return 0;
    }

    public int deleteDocument(String documentName){


        // daca documentul nu are cel putin 6 caractere, se returneaza un mesaj de eroare
        if(!dv.isDocumentValid(documentName)){
            return -1;
        }
        // daca documentul nu se afla in baza de date, se returneaza un mesaj de eroare
        if(!dr.isDocumentInDB(documentName.toUpperCase())){
            return -2;
        }

        int deletedItemIndex = getIndexOfDeletedItem(documentName.toUpperCase());
        dr.deleteDocument(documentName.toUpperCase());
        return deletedItemIndex;
    }
}
