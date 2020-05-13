package pl.edu.wszib.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int id;
    private String e_name;
    private String e_department;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_department() {
        return e_department;
    }

    public void setE_department(String e_department) {
        this.e_department = e_department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", e_name='" + e_name + '\'' +
                ", e_department='" + e_department + '\'' +
                '}';
    }
}
