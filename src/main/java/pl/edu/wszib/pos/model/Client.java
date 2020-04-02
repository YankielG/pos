package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany
    private Long Id;
    @Column(nullable = false)
    private String fName;
    @Column(nullable = false)
    private String lName;
    private String zip;
    private String city;
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column (nullable = false)
    private String email;

    public Client() {
    }

    public Client(String fName, String lName, String zip,
                  String city, String address, String phone, String email) {
        this.fName = fName;
        this.lName = lName;
        this.zip = zip;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
