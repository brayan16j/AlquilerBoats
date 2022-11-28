package com.example.usa.boats.repository;

import com.example.usa.boats.model.MessageModel;
import com.example.usa.boats.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAllMessages(){
        return (List<MessageModel>) messageCrudRepository.findAll();
    }
    public Optional<MessageModel> getMessage(Integer id){
        return messageCrudRepository.findById(id);
    }
    public MessageModel saveMessage(MessageModel messageModel){
        return messageCrudRepository.save(messageModel);
    }
    public boolean deleteMessage(Integer id){
        messageCrudRepository.deleteById(id);
        return true;
    }
    public MessageModel updateMessage(MessageModel messageModel){
        return messageCrudRepository.save(messageModel);
    }

}
