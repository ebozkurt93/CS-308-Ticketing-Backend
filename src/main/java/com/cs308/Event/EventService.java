package com.cs308.Event;

import java.util.ArrayList;
import java.util.Collection;

import com.cs308.Category.Category;
import com.cs308.Category.CategoryRepository;
import com.cs308.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryService categoryService;

    public void addEvent(Event e) {
      // Collection<Category> categories = e.getCategories();
      // categories.forEach(category -> categoryService.addCategory(category));
        eventRepository.save(e);
    }

    public void removeEvent(Event e) {
        eventRepository.delete(e);
    }

    public ArrayList<Event> getAllEvents() {

        ArrayList<Event> events = new ArrayList<Event>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

    public Event getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public Event getEventById(int id) {
        return eventRepository.findById(id);
    }


}
