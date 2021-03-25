package entity;
import javax.persistence.*;
@Entity
@Table(name = "Cereri")
public class Cerere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial",name = "id_column")
    private int idCerere;

    @Column(name = "user_id_column")
    private String userId;

    @Column(name = "tip_cerere_column")
    private String tipCerere;

    @Column(name = "data_column")
    private String data;

    @Column(name = "nume_column")
    private String nume;

    @Column (name = "prenume_column")
    private String prenume;

    @Column(name = "adresa_column")
    private String adresa;

    @Column (name = "numar_cereri_column")
    private int numarCereri;

    @Column (name = "aprobare_column")
    private String aprobare;

    // constructori folositi de baza de date
    public Cerere(){};
    public Cerere(int idCerere,String tipCerere, String adresa, String aprobare){
        this.idCerere = idCerere;
        this.tipCerere = tipCerere;
        this.adresa = adresa;
        this.aprobare = aprobare;
    }

    // constructor pentru crearea unui obiect de tip cerere

    public Cerere(int idCerere, String tipCerere, String data, String adresa, int numarCereri, String aprobare){
        this.idCerere = idCerere;
        this.tipCerere = tipCerere;
        this.data = data;
        this.adresa = adresa;
        this.numarCereri = numarCereri;
        this.aprobare = aprobare;
    }

    public Cerere(int idCerere, String userId, String tipCerere, String data,String nume,String prenume,String adresa,int numarCereri, String aprobare){
        this.idCerere = idCerere;
        this.userId = userId;
        this.tipCerere = tipCerere;
        this.data = data;
        this.nume  = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.numarCereri = numarCereri;
        this.aprobare = aprobare;
    }

    public Cerere( String userId, String tipCerere, String data,String nume,String prenume,String adresa,int numarCereri, String aprobare){
        this.userId = userId;
        this.tipCerere = tipCerere;
        this.data = data;
        this.nume  = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.numarCereri = numarCereri;
        this.aprobare = aprobare;
    }
    public int getIdCerere() {
        return idCerere;
    }

    public String getTipCerere() {
        return tipCerere;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getAprobare() {
        return aprobare;
    }

    public String getData() {
        return data;
    }

    public int getNumarCereri() {
        return numarCereri;
    }
}
