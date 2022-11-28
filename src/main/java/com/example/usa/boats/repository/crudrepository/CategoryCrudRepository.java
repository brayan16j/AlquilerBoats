package com.example.usa.boats.repository.crudrepository;

import com.example.usa.boats.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel, Integer> {
}
