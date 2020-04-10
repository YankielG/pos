package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long rId;
    //nazwa roli
    private String roleName;

    public Long getId() {
        return rId;
    }

    public void setId(Long id) {
        this.rId = rId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName){
        this.roleName = roleName;
    }
}
