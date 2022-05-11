package com.sunglowsys.embaddeableE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastName;
    private AddressEmp add;

    public Employee() {}

    public Employee(Long id, String firstname, String lastName, AddressEmp add) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.add = add;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressEmp getAdd() {
        return add;
    }

    public void setAdd(AddressEmp add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", add=" + add +
                '}';
    }
}
