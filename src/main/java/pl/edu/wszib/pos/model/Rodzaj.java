package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "rodzaj")
public class Rodzaj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rodzajId;
    private String rodzajNazwa;

    public Integer getRodzajId() {
        return rodzajId;
    }

    public void setRodzajId(Integer rodzajId) {
        this.rodzajId = rodzajId;
    }

    public String getRodzajNazwa() {
        return rodzajNazwa;
    }

    public void setRodzajNazwa(String rodzajNazwa) {
        this.rodzajNazwa = rodzajNazwa;
    }
}
