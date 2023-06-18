package com.example.demo.entity;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_demo3")

public class CustEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //default auto incremented primary key generation

    @Column(name="cust_id",nullable=false)
    private int id;
    
    @Column(name="cust_name",nullable=false)
    private String name;
    
    @Column(name="cust_mob",nullable = false)
    private String mob;

    @Column(name="cust_add",nullable=false)
    private String add;
    
    @Column(name="cust_city",nullable=false)
    private String city;
 
    public CustEntity() {
    }

    public CustEntity(int id, String name, String mob, String add, String city) {
        this.id = id;
        this.name = name;
        this.mob = mob;
        this.add = add;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CustEntity [id=" + id + ", name=" + name + ", mob=" + mob + ", add=" + add + ", city=" + city + "]";
    }
}