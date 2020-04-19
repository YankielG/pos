package pl.edu.wszib.pos.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hId")
    private Long hId;
    // id zgłoszenia
    private Long zId;
    //data zapisu historii
    private Date hData;
    //rodzaj operacji
    private String hDescription;
    //kto wykonał operację
    private String hUser;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zgloszenie_id")
    private Zgloszenie zgloszenie;


    public History(Long zId, Date hData, String hDescription, String hUser) {
        this.zId = zId;
        this.hData = hData;
        this.hDescription = hDescription;
        this.hUser = hUser;
    }

    public Long getId() {
        return hId;
    }

    public void setId(Long id) {
        this.hId = hId;
    }

    public Long getzId() {
        return zId;
    }

    public void setzId(Long zId) {
        this.zId = zId;
    }

    public Date gethData() {
        return hData;
    }

    public void sethData(Date hData) {
        this.hData = hData;
    }

    public String gethDescription() {
        return hDescription;
    }

    public void sethDescription(String hDescription) {
        this.hDescription = hDescription;
    }

    public String gethUser() {
        return hUser;
    }

    public void sethUser(String hUser) {
        this.hUser = hUser;
    }

    public Zgloszenie getZgloszenie() {
        return zgloszenie;
    }

    public void setZgloszenie(Zgloszenie zgloszenie) {
        this.zgloszenie = zgloszenie;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + hId +
                ", zId=" + zId +
                ", hData=" + hData +
                ", hDescription='" + hDescription + '\'' +
                ", hUser='" + hUser + '\'' +
                '}';
    }
}
