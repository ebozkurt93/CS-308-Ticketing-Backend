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
    @Column(nullable=true)
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
}
