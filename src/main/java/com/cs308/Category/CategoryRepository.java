package com.cs308.Category;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by erdem on 30.05.2017.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findById(int id);
}
