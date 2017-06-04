package com.cs308.Event;

import com.cs308.Category.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EventRepository extends CrudRepository<Event,Long> {
	Event findByName(String name);
	Event findById(int id);
	Event findByCategoriesContains(ArrayList<Category> categories);

}
