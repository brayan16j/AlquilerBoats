package com.example.usa.boats.controller;

import com.example.usa.boats.model.CategoryModel;
import com.example.usa.boats.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<CategoryModel> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategory(@PathVariable("id")Integer id){
        return categoryService.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel saveCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.saveCategory(categoryModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel updateCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.updateCategory(categoryModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return categoryService.deleteCategory(id);
    }

}
