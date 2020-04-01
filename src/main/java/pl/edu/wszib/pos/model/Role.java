package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany
    private Long rId;
    @Column(nullable = false)
    private String nameRole;
    @Column(nullable = false)
    private boolean isActive;

    public Role() {
    }

    public Role (Long rId, String nameRole, boolean isActive){
        this.rId = rId;
        this.nameRole = nameRole;
        this.isActive = isActive;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Role{" +
                "nameRole='" + nameRole + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
