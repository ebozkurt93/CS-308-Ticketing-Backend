package com.cs308.Event.EventMedia;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventMediaService {
	
	@Autowired
	private EventMediaRepository eventMediaRepository;
	
	public void addEvent(EventMedia eventMedia) {
		eventMediaRepository.save(eventMedia);
	}
	
	public ArrayList<EventMedia> getAllEventMedia() {

		ArrayList<EventMedia> eventMedias = new ArrayList<EventMedia>();
		eventMediaRepository.findAll().forEach(eventMedias::add);
		return eventMedias;
	}

	public EventMedia getEventMediaById(String id) {
		return eventMediaRepository.findById(id);
	}

}
