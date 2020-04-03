package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class StatusZgloszenia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statusId")
    private Integer statusId;
    private String statusName;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
