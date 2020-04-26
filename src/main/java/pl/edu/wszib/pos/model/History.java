package pl.edu.wszib.pos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    // id zgłoszenia
    private Date hData;
    //rodzaj operacji
    private String hDescription;
    //kto wykonał operację
    private String hUser;
    //id zgloszenia
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "zgloszenie_id", nullable = false)
//    private Zgloszenie zgloszenie;
//    @ManyToMany(fetch = FetchType.LAZY,cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "user",
//            joinColumns = { @JoinColumn(name = "history_id") },
//            inverseJoinColumns = { @JoinColumn(name = "user_id") })
//    private Set<User> genres = new HashSet<>();


}
