package pl.edu.wszib.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "zgloszenia")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    Date date;
    String clientName;
    String clientEmail;
    String nStatus;
    String nSnComputer;

    public Notification() {
    }

    public Notification(Date date, String clientName,
                        String clientEmail, String nStatus, String nSnComputer) {
        this.date = new Date();
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.nStatus = nStatus;
        this.nSnComputer = nSnComputer;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getnStatus() {
        return nStatus;
    }

    public void setnStatus(String nStatus) {
        this.nStatus = nStatus;
    }

    public String getnSnComputer() {
        return nSnComputer;
    }

    public void setnSnComputer(String nSnComputer) {
        this.nSnComputer = nSnComputer;
    }
}
