package pl.edu.wszib.pos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //id zgłoszenia
    private Long zId;
    //data zapisu historii
    private Date hData;
    //czas zapisu historii
    private Date hTime;
    //rodzaj operacji
    private String hDescription;
    //kto wykonał operację
    private String hUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date gethTime() {
        return hTime;
    }

    public void sethTime(Date hTime) {
        this.hTime = hTime;
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
}
