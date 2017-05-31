package com.cs308.Ticket;

import com.cs308.Event.Event;
import com.cs308.User.Role;
import com.cs308.User.User;

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

    @ElementCollection(targetClass = Category.class)
    @JoinTable(name = "tickets", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "categoryId", nullable = false)

    private Category category;


    @ElementCollection(targetClass = User.class)
    @JoinTable(name = "tickets", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "userId", nullable = false)

    private User user;
    @Column(nullable = false)
    private int seatname;

    public Ticket(Category category, User user, int seatname) {
        this.category = category;
        this.user = user;
        this.seatname = seatname;
    }

    public Ticket() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeatname() {
        return seatname;
    }

    public void setSeatname(int seatname) {
        this.seatname = seatname;
    }
}
