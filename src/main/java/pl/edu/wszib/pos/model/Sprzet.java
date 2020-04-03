package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "sprzet")
public class Sprzet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sprzetId;
    @Column(name = "sprzetNazwa", nullable = false)
    private String sprzetNazwa;
    private String sprzetSn;
    private String sprzetRodzaj;

    public Integer getSprzetId() {
        return sprzetId;
    }

    public void setSprzetId(Integer sprzetId) {
        this.sprzetId = sprzetId;
    }

    public String getSprzetNazwa() {
        return sprzetNazwa;
    }

    public void setSprzetNazwa(String sprzetNazwa) {
        this.sprzetNazwa = sprzetNazwa;
    }

    public String getSprzetSn() {
        return sprzetSn;
    }

    public void setSprzetSn(String sprzetSn) {
        this.sprzetSn = sprzetSn;
    }

    public String getSprzetRodzaj() {
        return sprzetRodzaj;
    }

    public void setSprzetRodzaj(String sprzetRodzaj) {
        this.sprzetRodzaj = sprzetRodzaj;
    }
}
