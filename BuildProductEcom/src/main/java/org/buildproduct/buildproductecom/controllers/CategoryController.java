package org.buildproduct.buildproductecom.controllers;

import lombok.Getter;
import org.buildproduct.buildproductecom.models.Category;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public class CategoryController {

    @GetMapping("/category")
    public List<Category> getCategory(){
        return null;
    }




}
