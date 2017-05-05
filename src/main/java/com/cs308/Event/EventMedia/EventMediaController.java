package com.cs308.Event.EventMedia;

import java.util.ArrayList;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs308.config.JwtMyHelper;

@RestController
@RequestMapping(path = "/eventmedia")
public class EventMediaController {
	
	@Autowired
	private EventMediaService eventMediaService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/secure/getalleventmedia")
	public ArrayList<EventMedia> getAllEventMedia(@RequestHeader(value = "Authorization") String jwt) throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			return eventMediaService.getAllEventMedia();
		} else
			throw new ServletException("You are not authorized to do that");
	}
	

}
