package com.cs308.Category;


import com.cs308.config.JwtMyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.ArrayList;

/**
 * Created by erdem on 30.05.2017.
 */

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //can also update with this
    @RequestMapping(method = RequestMethod.POST, value = "/secure/add")
    public void addCategory(@RequestHeader(value = "Authorization") String jwt, @RequestBody Category c) throws ServletException {
        if (JwtMyHelper.getIfJWTAdmin(jwt)) {
            categoryService.addCategory(c);

        } else
            throw new ServletException("You are not authorized to do that");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallcategories")
    public ArrayList<Category> getAllEvents() throws ServletException {
        return categoryService.getAllCategories();
    }
}
