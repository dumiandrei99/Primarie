package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Locuinte")
public class Locuinte {
    @Id
    @Column(name = "id_locuinta_column")
    private String idLocuinta;

    @Column(name = "id_propietar_column")
    private String idPropietar;

    @Column (name = "nume_propietar_column")
    private String numePropietar;

    @Column(name = "prenume_propietar_column")
    private String prenumePropietar;

    @Column(name = "adresa_column")
    private String adresa;

    // constructori folositi in baza de date
    public Locuinte(){};

    public Locuinte(String UUID,String idPropietar,String numePropietar,String prenumePropietar,String adresa){
        this.idLocuinta = UUID;
        this.idPropietar = idPropietar;
        this.numePropietar = numePropietar;
        this.prenumePropietar = prenumePropietar;
        this.adresa = adresa;
    }

    public Locuinte(String idLocuinta, String adresa){
        this.adresa = adresa;
        this.idLocuinta = idLocuinta;
    }

    public String getIdLocuinta() {
        return idLocuinta;
    }

    public String getAdresa() {
        return adresa;
    }
}
