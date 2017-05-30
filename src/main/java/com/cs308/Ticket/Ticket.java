package com.cs308.Ticket;

import com.cs308.Event.Event;

import javax.persistence.*;

/**
 * Created by erdem on 30.05.2017.
 */

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable=false)
    private Category category;
    @Column(nullable = false)
    private Event event;

    public Ticket() {
    }

    public Ticket(Category category, Event event) {
        this.category = category;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
