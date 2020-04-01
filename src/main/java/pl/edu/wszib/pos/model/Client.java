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
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column (nullable = false)
    private String email;

    public Client() {
    }
}
