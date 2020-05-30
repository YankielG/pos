package pl.edu.wszib.pos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "zgloszenie")
public class Zgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //dane zgłaszającego
    private String name;
    //email zgłaszającego
    private String email;
    //telefon zgłaszającego
    @Length(min = 9, max = 11, message = "Numer telefonu musi zawierać się pomiędzy 9 a 11 znakami")
    private String phone;
    //czego dotyczy zgłoszenie
    private String type;
    //numer seryjny
    private String serialNumber;
    // data zgłoszenia
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "c_data", updatable = false, nullable = false)
    private Date cData;
    //opis zgłoszenia
    private String description;
    // opis naprawy
    private String endDescription;
    //czy usunięto
    @Column(columnDefinition = "boolean default false")
    private boolean del;
    //czy jest w realizacji
    @Column(columnDefinition = "boolean default false")
    private boolean is_proceed;
    //czy zakończono
    @Column(columnDefinition = "boolean default false")
    private boolean is_end;
    private String selectedUser;
    @Column(columnDefinition = "boolean default false")
    private boolean archive;

//    //komu przydzielono
////    private int user_id;
    @OneToMany(targetEntity = History.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<History> histories;

//    @OneToMany(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    private List<User> users;

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

    public boolean isIs_proceed() {
        return is_proceed;
    }

    public void setIs_proceed(boolean is_proceed) {
        this.is_proceed = is_proceed;
    }

    public boolean isIs_end() {
        return is_end;
    }

    public void setIs_end(boolean is_end) {
        this.is_end = is_end;
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

    public Zgloszenie() {
    }

    public Zgloszenie(String name, String email, String phone, String type, String serialNumber, Date cData,
                      String description, String endDescription, Boolean del, Boolean is_proceed, Boolean is_end, Boolean archive, List<History> histories) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.serialNumber = serialNumber;
        this.cData = cData;
        this.description = description;
        this.endDescription = endDescription;
        this.del = del;
        this.is_proceed = is_proceed;
        this.is_end = is_end;
        this.archive = archive;
        this.histories = histories;
    }

}
