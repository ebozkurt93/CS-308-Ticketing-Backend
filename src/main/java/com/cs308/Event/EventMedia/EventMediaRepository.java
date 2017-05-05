package com.cs308.Event.EventMedia;

import org.springframework.data.repository.CrudRepository;


public interface EventMediaRepository extends CrudRepository<EventMedia, Long> {

	EventMedia findById(String id);

}
