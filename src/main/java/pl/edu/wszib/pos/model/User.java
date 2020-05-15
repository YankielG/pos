package pl.edu.wszib.pos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    @Length(min = 5, message = "*Nazwa użytkownika musi zawierać co najmniej 5 znaków")
    @NotEmpty(message = "*Proszę wprowadzić nazwę użytkownika")
    private String userName;
    @Column(name = "email")
    @Email(message = "*Proszę wprowadzić poprawny adres e-mail")
    @NotEmpty(message = "*Adres e-mail nie może być pusty")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Hasło musi zawierać co najmniej 5 znaków")
    @NotEmpty(message = "*Proszę wprowadzić hasło")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Proszę podać imię i nazwisko")
    private String name;
    @Column(name = "phone")
    @NotEmpty(message = "*Proszę podać numer telefonu")
    private String lastName;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
//    @ManyToOne
//    private Zgloszenie zgloszenie;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "zgloszenie_id")
//    private Zgloszenie zgloszenie;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public Zgloszenie getZgloszenie() {
//        return zgloszenie;
//    }
//
//    public void setZgloszenie(Zgloszenie zgloszenie) {
//        this.zgloszenie = zgloszenie;
//    }

    public User() {
    }
}
