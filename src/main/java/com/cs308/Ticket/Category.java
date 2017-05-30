package com.cs308.Ticket;

import com.cs308.Event.Event;

import javax.persistence.*;

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
    private String name;
    @Column(nullable=false)
    private double price;

    public Category(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Category() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
