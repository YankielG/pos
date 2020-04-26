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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

}
