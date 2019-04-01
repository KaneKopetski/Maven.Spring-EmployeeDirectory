package io.zipcoder.persistenceapp.entity;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private long number;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true, name = "manager_id")
    private Employee Manager;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return Manager;
    }

    public void setManager(Employee manager) {
        Manager = manager;
    }
}
