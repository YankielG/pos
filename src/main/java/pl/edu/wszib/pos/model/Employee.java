package pl.edu.wszib.pos.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eId;
    @OneToMany
    @Column(nullable = false)
    private String eOIC; //Osobisty Identyfikator Cyfrowy - do logowania (nick)
    @Column(nullable = false)
    private String eFName;
    @Column(nullable = false)
    private String eLName;
    @Column(nullable = false)
    private String eEmail;
    @Column
    private String ePhone;
    @Column(nullable = false)
    private boolean eActive;

    public Employee() {
    }
    public Employee(String eOIC, String eFName, String eLName,
                    String eEmail, String ePhone, boolean eActive) {
        this.eOIC = eOIC;
        this.eFName = eFName;
        this.eLName = eLName;
        this.eEmail = eEmail;
        this.ePhone = ePhone;
        this.eActive = eActive;
    }

    public String geteOIC() {
        return eOIC;
    }

    public void seteOIC(String eOIC) {
        this.eOIC = eOIC;
    }

    public String geteFName() {
        return eFName;
    }

    public void seteFName(String eFName) {
        this.eFName = eFName;
    }

    public String geteLName() {
        return eLName;
    }

    public void seteLName(String eLName) {
        this.eLName = eLName;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public boolean iseActive() {
        return eActive;
    }

    public void seteActive(boolean eActive) {
        this.eActive = eActive;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eOIC='" + eOIC + '\'' +
                ", eFName='" + eFName + '\'' +
                ", eLName='" + eLName + '\'' +
                ", eEmail='" + eEmail + '\'' +
                ", ePhone='" + ePhone + '\'' +
                ", eActive=" + eActive +
                '}';
    }
}
