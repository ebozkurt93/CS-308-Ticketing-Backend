package com.cs308.Ticket;

import com.cs308.Category.Category;
import com.cs308.Event.Event;
import com.cs308.Event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by erdem on 31.05.2017.
 */

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventRepository eventRepository;

    public void addTicket(Ticket t) {
        ticketRepository.save(t);
    }

    public ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id);
    }

    public ArrayList<Ticket> getAllTicketsByUserId(int id) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAllByUserId(id).forEach(tickets::add);
        return tickets;
    }

    public ArrayList<Ticket> getAllTicketsByEventId(int id) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        Event event = eventRepository.findById(id);
        Collection<Category> categories = event.getCategories();

        categories.forEach(category -> tickets.addAll(ticketRepository.findAllByCategoryId(category.getId())));


        //ticketRepository.findAllByCategoryId(id).forEach(tickets::add);
        return tickets;
    }
}
