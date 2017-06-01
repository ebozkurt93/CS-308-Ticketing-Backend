package com.cs308.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by erdem on 31.05.2017.
 */

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void addTicket(Ticket t) {
        ticketRepository.save(t);
    }

    public ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    public Ticket getTicketById(int id) {return ticketRepository.findById(id);}

    public ArrayList<Ticket> getAllTicketsByUserId(int id) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAllByUserId(id).forEach(tickets::add);
        return tickets;
    }

    public ArrayList<Ticket> getAllTicketsByEventId(int id) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAllByEventId(id).forEach(tickets::add);
        return tickets;
    }
}
