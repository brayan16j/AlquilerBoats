package com.example.usa.boats.repository.crudrepository;

import com.example.usa.boats.model.BoatModel;
import org.springframework.data.repository.CrudRepository;

public interface BoatCrudRepository  extends CrudRepository<BoatModel, Integer> {
}
