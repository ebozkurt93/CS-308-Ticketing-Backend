package com.cs308.Event;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs308.User.User;
import com.cs308.User.UserRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	public void addEvent(Event e){
		eventRepository.save(e);
	}
	
	public ArrayList<Event> getAllEvents() {

		ArrayList<Event> events = new ArrayList<Event>();
		eventRepository.findAll().forEach(events::add);
		return events;
	}
	
	public Event getEventByName(String name) {
		return eventRepository.findByName(name);
	}
	
	
	
	
}
