package pl.edu.wszib.pos.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "klient")
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer klientId;
    private String klientFirstName;
    private String klientLastName;
    private String klientPhone;
    private String klientEmail;

    public Integer getKlientId() {
        return klientId;
    }

    public void setKlientId(Integer klientId) {
        this.klientId = klientId;
    }

    public String getKlientFirstName() {
        return klientFirstName;
    }

    public void setKlientFirstName(String klientFirstName) {
        this.klientFirstName = klientFirstName;
    }

    public String getKlientLastName() {
        return klientLastName;
    }

    public void setKlientLastName(String klientLastName) {
        this.klientLastName = klientLastName;
    }

    public String getKlientPhone() {
        return klientPhone;
    }

    public void setKlientPhone(String klientPhone) {
        this.klientPhone = klientPhone;
    }

    public String getKlientEmail() {
        return klientEmail;
    }

    public void setKlientEmail(String klientEmail) {
        this.klientEmail = klientEmail;
    }
}
