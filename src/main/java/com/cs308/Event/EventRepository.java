package com.cs308.Event;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Long> {
	Event findByName(String name);
	Event findById(int id);

}
