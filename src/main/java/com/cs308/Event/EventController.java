package com.cs308.Event;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;

import com.cs308.Category.Category;
import com.cs308.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs308.config.JwtMyHelper;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @Autowired
	private CategoryService categoryService;


    //also can be used to update an event
    @RequestMapping(method = RequestMethod.POST, value = "/secure/add")
    public void addEvent(@RequestHeader(value = "Authorization") String jwt, @RequestBody Event e) throws ServletException {
        if (JwtMyHelper.getIfJWTAdmin(jwt)) {
            //Collection<Category> categories = e.getCategories();
            eventService.addEvent(e);

        } else
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallevents")
    public ArrayList<Event> getAllEvents() throws ServletException {
        return eventService.getAllEvents();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/geteventbyid")
    public Event getEvent(@RequestBody Event e) throws ServletException {
        return eventService.getEventById(e.getId());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/remove")
    public void removeEvent(@RequestHeader(value = "Authorization") String jwt, @RequestBody Event e) throws ServletException {
        if (JwtMyHelper.getIfJWTAdmin(jwt)) {
            eventService.removeEvent(e);
            Collection<Category> categories = e.getCategories();
            categories.forEach(category -> categoryService.removeCategory(category));

        } else
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getcategories")
    public Collection<Category> getEventCategories(@RequestBody Event e) throws ServletException {

        Event event = eventService.getEventById(e.getId());

        Collection<Category> category = event.getCategories();
        return category;
    }


}