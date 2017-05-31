package com.cs308.Ticket;


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
    private int startSeat;
    @Column(nullable=false)
    private int endSeat;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private double price;

    public Category() {
    }

}
