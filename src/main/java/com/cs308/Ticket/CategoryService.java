package com.cs308.Ticket;

/**
 * Created by erdem on 30.05.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category c){
        categoryRepository.save(c);
    }

//disabled, don't enable unless really necessary
    /*
    public void removeCategory(Event c) {
        categoryRepository.delete(c);
    }
*/
    public ArrayList<Category> getAllCategories() {

        ArrayList<Category> categories = new ArrayList<Category>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }


    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
}
