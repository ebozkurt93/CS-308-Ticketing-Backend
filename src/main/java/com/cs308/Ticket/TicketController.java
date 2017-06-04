package com.cs308.Ticket;

import com.cs308.Event.Event;
import com.cs308.User.User;
import com.cs308.config.JwtMyHelper;
import com.cs308.config.key.KeyFactory;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.ArrayList;

/**
 * Created by erdem on 31.05.2017.
 */

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @RequestMapping(method = RequestMethod.POST, value = "/secure/createTicket")
    public void createTicket(@RequestHeader(value = "Authorization") String jwt, @RequestBody Ticket t) throws ServletException {
        if (JwtMyHelper.getIfJWTUser(jwt)) {
            ticketService.addTicket(t);

        } else
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/getAllTicketsForUser")
    public ArrayList<Ticket> getAllTicketsForUser(@RequestHeader(value = "Authorization") String jwt, @RequestBody User u) throws ServletException {
        if (JwtMyHelper.getIfJWTUser(jwt)) {
            int id = u.getId();
                return ticketService.getAllTicketsByUserId(id);
            }
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/getAllTicketsForEvent")
    public ArrayList<Ticket> getAllTicketsForEvent(@RequestHeader(value = "Authorization") String jwt, @RequestBody Event e) throws ServletException {
        if (JwtMyHelper.getIfJWTUser(jwt) || JwtMyHelper.getIfJWTAdmin(jwt)) {
            int id = e.getId();

                return ticketService.getAllTicketsByEventId(id);
            }
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/getAllTicketsForUserAsAdmin")
    public ArrayList<Ticket> getAllTicketsForUserAsAdmin(@RequestHeader(value = "Authorization") String jwt, @RequestBody User u) throws ServletException {
        if (JwtMyHelper.getIfJWTAdmin(jwt)) {
            int userId = u.getId();

            return ticketService.getAllTicketsByUserId(userId);

        } else
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/getAllTickets")
    public ArrayList<Ticket> getAllTickets(@RequestHeader(value = "Authorization") String jwt) throws ServletException {
        if (JwtMyHelper.getIfJWTAdmin(jwt)) {
            return ticketService.getAllTickets();

        } else
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/getTicket")
    public Ticket getTicket(@RequestHeader(value = "Authorization") String jwt, @RequestBody Ticket t) throws ServletException {
        if (JwtMyHelper.getIfJWTUser(jwt) || JwtMyHelper.getIfJWTAdmin(jwt)) {
            return ticketService.getTicketById(t.getId());

        } else
            throw new ServletException("You are not authorized to do that");
    }

}
