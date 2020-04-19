package pl.edu.wszib.pos.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "zgloszenie")
public class Zgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @Column(name = "id")
    private Long id;
    //dane zgłaszającego
    private String name;
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
    // opis naprawy
    private String endDescription;
    //czy usunięto
    @Column(columnDefinition = "boolean default false")
    private boolean del;
    //komu przydzielono
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEndDescription() {
        return endDescription;
    }

    public void setEndDescription(String endDescription) {
        this.endDescription = endDescription;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
