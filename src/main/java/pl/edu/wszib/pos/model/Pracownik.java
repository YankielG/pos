package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "pracownik")
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "OIC") //Osobisty Identyfikator Cyfrowy lub nick
    private String userOic;
    private String userPass;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPhone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserOic() {
        return userOic;
    }

    public void setUserOic(String userOic) {
        this.userOic = userOic;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

}
