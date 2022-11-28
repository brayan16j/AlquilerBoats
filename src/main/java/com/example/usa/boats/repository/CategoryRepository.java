package com.example.usa.boats.repository;

import com.example.usa.boats.model.CategoryModel;
import com.example.usa.boats.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAllCategory(){
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getCategory(Integer id){
        return categoryCrudRepository.findById(id);
    }
    public CategoryModel saveCategory(CategoryModel categoryModel){
        return categoryCrudRepository.save(categoryModel);
    }
    public boolean deleteCategory(Integer id){
        categoryCrudRepository.deleteById(id);
        return true;
    }
    public CategoryModel updateCategory(CategoryModel categoryModel){
        return categoryCrudRepository.save(categoryModel);
    }
}
