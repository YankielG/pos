package pl.edu.wszib.pos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // login użytkownika
    private String uLogin;
    //hasło użytkownika
    private String uPassword;
    //imię użytkownika
    private String uFName;
    //nazwisko użytkownika
    private String uLName;
    //e-mail użytkownika
    private String uEmail;
    //telefon użytkownika
    private String uPhone;
    //czy aktywny
    private String uActive;
    //rola użytkownika w aplikacji
    private String uRole;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Zgloszenie> zgloszenieList;

    public User(long id, String uLogin, String uFName, String uLName) {
        this.id = id;
        this.uLogin = uLogin;
        this.uFName = uFName;
        this.uLName = uLName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getuLogin() {
        return uLogin;
    }

    public void setuLogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuFName() {
        return uFName;
    }

    public void setuFName(String uFName) {
        this.uFName = uFName;
    }

    public String getuLName() {
        return uLName;
    }

    public void setuLName(String uLName) {
        this.uLName = uLName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuActive() {
        return uActive;
    }

    public void setuActive(String uActive) {
        this.uActive = uActive;
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    public User() {
    }

    public List<Zgloszenie> getZgloszenieList() {
        return zgloszenieList;
    }

    public void setZgloszenieList(List<Zgloszenie> zgloszenieList) {
        this.zgloszenieList = zgloszenieList;
    }
}
