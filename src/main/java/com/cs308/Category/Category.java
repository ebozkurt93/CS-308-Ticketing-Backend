package com.cs308.Category;


import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by erdem on 30.05.2017.
 */

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable=false)
    private int startSeat;
    @Column(nullable=false)
    private int endSeat;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private double price;

    public Category() {
    }

    public Category(int startSeat, int endSeat, String name, double price) {
        this.startSeat = startSeat;
        this.endSeat = endSeat;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartSeat() {
        return startSeat;
    }

    public void setStartSeat(int startSeat) {
        this.startSeat = startSeat;
    }

    public int getEndSeat() {
        return endSeat;
    }

    public void setEndSeat(int endSeat) {
        this.endSeat = endSeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
