package pl.edu.wszib.pos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "zgloszenie")
public class Zgloszenie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer zglId;

    private Date zglData = new Date();

    @ManyToOne
    @JoinColumn(name = "katId")
    private KategoriaZgloszenia kategoriaZgloszenia;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private StatusZgloszenia statusZgloszenia;

    @ManyToOne
    @JoinColumn(name = "userOic")
    private Pracownik pracownik;

    @ManyToOne
    @JoinColumn(name = "klientaId")
    private Klient klient;

    @ManyToOne
    @JoinColumn(name = "sprzetId")
    private Sprzet sprzet;

    @Column(name = "zglOpis", nullable = false)
    private String zglOpis;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getZglId() {
        return zglId;
    }

    public void setZglId(Integer zglId) {
        this.zglId = zglId;
    }

    public Date getZglData() {
        return zglData;
    }

    public void setZglData(Date zglData) {
        this.zglData = zglData;
    }

    public KategoriaZgloszenia getKategoriaZgloszenia() {
        return kategoriaZgloszenia;
    }

    public void setKategoriaZgloszenia(KategoriaZgloszenia kategoriaZgloszenia) {
        this.kategoriaZgloszenia = kategoriaZgloszenia;
    }

    public StatusZgloszenia getStatusZgloszenia() {
        return statusZgloszenia;
    }

    public void setStatusZgloszenia(StatusZgloszenia statusZgloszenia) {
        this.statusZgloszenia = statusZgloszenia;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Sprzet getSprzet() {
        return sprzet;
    }

    public void setSprzet(Sprzet sprzet) {
        this.sprzet = sprzet;
    }

    public String getZglOpis() {
        return zglOpis;
    }

    public void setZglOpis(String zglOpis) {
        this.zglOpis = zglOpis;
    }
}
