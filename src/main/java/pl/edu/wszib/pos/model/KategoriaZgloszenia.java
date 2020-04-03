package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "kategoria")
public class KategoriaZgloszenia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "katId")
    private Integer katId;
    private String nazwaKategorii;

    public Integer getkatId() {
        return katId;
    }

    public void setkatId(Integer katId) {
        this.katId = katId;
    }

    public String getNazwaKategorii() {
        return nazwaKategorii;
    }

    public void setNazwaKategorii(String nazwaKategorii) {
        this.nazwaKategorii = nazwaKategorii;
    }
}
