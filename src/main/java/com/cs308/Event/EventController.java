package com.cs308.Event;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/secure/add")
	public void addEvent(@RequestBody Event e){
		eventService.addEvent(e);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/secure/getallevents")
	public ArrayList<Event> getAllEvents() {
		return eventService.getAllEvents();
	}
	
	
	
	
	

}