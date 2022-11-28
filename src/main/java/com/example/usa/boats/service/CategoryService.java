package com.example.usa.boats.service;

import com.example.usa.boats.model.CategoryModel;
import com.example.usa.boats.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategory(){
        return categoryRepository.getAllCategory();
    }
    public Optional<CategoryModel> getCategory(Integer id){
        return categoryRepository.getCategory(id);
    }
    public CategoryModel saveCategory(CategoryModel categoryModel){
        if(categoryModel.getId()==null){
            return categoryRepository.saveCategory(categoryModel);
        }else {
            Optional<CategoryModel> categoryEncontrada = categoryRepository.getCategory(categoryModel.getId());
            if (categoryEncontrada.isEmpty()){
                return categoryRepository.saveCategory(categoryModel);
            }else {
                return categoryModel;
            }
        }
    }
    public boolean deleteCategory(Integer id){
        Boolean respuesta = getCategory(id).map(elemento -> {
            categoryRepository.deleteCategory(elemento.getId()); //
            return true;
        }).orElse(false);
        return respuesta;
    }
    public CategoryModel updateCategory(CategoryModel categoryModel) {
        if (categoryModel.getId() != null) {
            Optional<CategoryModel> categoryEncontrada = categoryRepository.getCategory(categoryModel.getId());
            if (!categoryEncontrada.isEmpty()) {
                if (categoryModel.getDescription() != null) {
                    categoryEncontrada.get().setDescription(categoryModel.getDescription());
                }
                if (categoryModel.getName() != null) {
                    categoryEncontrada.get().setName(categoryModel.getName());
                }
                return categoryRepository.saveCategory(categoryEncontrada.get());
            }
        }
        return categoryModel;
    }
}