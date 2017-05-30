package com.cs308.Ticket;

import javax.persistence.*;

/**
 * Created by erdem on 30.05.2017.
 */
@Entity
@Table(name="seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable=false)
    private Category category;
    @Column(nullable=false)
    private boolean available;

    public Seat(Category category) {
        this.category = category;
        this.available = true;
    }
}
