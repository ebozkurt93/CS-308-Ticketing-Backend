package com.cs308.Event;

import java.util.ArrayList;

import javax.servlet.ServletException;

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

	@RequestMapping(method = RequestMethod.POST, value = "/secure/add")
	public void addEvent(@RequestHeader(value = "Authorization") String jwt, @RequestBody Event e) throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			eventService.addEvent(e);

		} else
			throw new ServletException("You are not authorized to do that");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/secure/getallevents")
	public ArrayList<Event> getAllEvents(@RequestHeader(value = "Authorization") String jwt) throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			return eventService.getAllEvents();

		} else
			throw new ServletException("You are not authorized to do that");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/secure/remove")
	public void removeEvent(@RequestHeader(value = "Authorization") String jwt, @RequestBody Event e) throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			eventService.removeEvent(e);

		} else
			throw new ServletException("You are not authorized to do that");
	}

}