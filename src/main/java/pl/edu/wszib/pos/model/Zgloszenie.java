package pl.edu.wszib.pos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Zgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //imie zgłaszającego
    private String fName;
    //nazwisko zgłaszającego
    private String lName;
    //email zgłaszającego
    private String email;
    //telefon zgłaszającego
    private String phone;
    //czego dotyczy zgłoszenie
    private String type;
    //numer seryjny
    private String serialNumber;
    // data zgłoszenia
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cData;
    //opis zgłoszenia
    private String description;
    //status zgłoszenia
    private String status;
    //komu przydzielono
    private Long allocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getcData() {
        return cData;
    }

    public void setcData(Date cData) {
        this.cData = cData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAllocation() {
        return allocation;
    }

    public void setAllocation(Long allocation) {
        this.allocation = allocation;
    }
}
