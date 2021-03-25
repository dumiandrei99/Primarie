package entity;
import javax.persistence.*;

@Entity
@Table(name = "Documente")

public class Document {
    @Id
    @Column(name = "id_doc_column")
    private String id;

    @Column(name = "tip_column")
    private String tipDocument;

    // constructori pt baza de date
    public Document(String tipDocument){
        this.tipDocument = tipDocument;
    }
    public Document(){};
    // constructori folositi in cod
    public Document (String id, String tipDocument){
        this.id = id;
        this.tipDocument = tipDocument;
    }

    public void setId(String id) { this.id = id;}

    public void setTipDocument(String tipDocument) {
        this.tipDocument = tipDocument;
    }

    public String getId() {
        return id;
    }

    public String getTipDocument() {
        return tipDocument;
    }
}
