package com.example.usa.boats.repository.crudrepository;

import com.example.usa.boats.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel, Integer> {
}
