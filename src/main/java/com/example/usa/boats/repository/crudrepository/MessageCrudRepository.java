package com.example.usa.boats.repository.crudrepository;

import com.example.usa.boats.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {
}
