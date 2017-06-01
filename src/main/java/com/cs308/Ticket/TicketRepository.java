package com.cs308.Ticket;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by erdem on 31.05.2017.
 */
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findById(int id);
    ArrayList<Ticket> findAllByUserId(int id);

    ArrayList<Ticket> findAllByCategoryId(int id);
}
