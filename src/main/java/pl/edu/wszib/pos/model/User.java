package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uId;
    // login użytkownika
    private String uLogin;
    //hasło użytkownika
    private String uPassword;
    //imię i nazwisko użytkownika
    private String uName;
    //e-mail użytkownika
    private String uEmail;
    //telefon użytkownika
    private String uPhone;
    //czy aktywny
    private String uActive;
    //rola użytkownika w aplikacji
    private String uRole;


    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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

    public User(long id, String uLogin, String uName) {
        super();
        this.uId = uId;
        this.uLogin = uLogin;
        this.uName = uName;
    }

}

