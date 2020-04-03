package pl.edu.wszib.pos.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Validated
@Entity
public class Notification {
    //id zgłoszenia
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nId;
    //data zgłoszenia do serwisu
    private Date nDate;
    //status zgłoszenia w serwisie : 1-nowe, 2-przydzielono serwisantowi, 3-naprawiono, 4-odebrano
    private String nStatus;
    //kto przyjął zgłoszenie
    @OneToMany
    private List<Employee> eId;

    public Notification() {
    }

    public Notification(Date nDate, String nStatus, List<Employee> eId) {
        this.nDate = nDate;
        this.nStatus = nStatus;
        this.eId = eId;
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public String getnStatus() {
        return nStatus;
    }

    public void setnStatus(String nStatus) {
        this.nStatus = nStatus;
    }

    public List<Employee> geteId() {
        return eId;
    }

    public void seteId(List<Employee> eId) {
        this.eId = eId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "nDate=" + nDate +
                ", nStatus='" + nStatus + '\'' +
                ", eId=" + eId +
                '}';
    }
}
