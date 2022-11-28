package com.example.usa.boats.service;

import com.example.usa.boats.model.MessageModel;
import com.example.usa.boats.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessages(){
        return messageRepository.getAllMessages();
    }
    public Optional<MessageModel> getMessage(Integer id){
        return messageRepository.getMessage(id);
    }
    public MessageModel saveMessage(MessageModel messageModel){
        if (messageModel.getIdMessage()==null){
            return messageRepository.saveMessage(messageModel);
        }else {
            Optional<MessageModel> messageEncontrado = getMessage(messageModel.getIdMessage());
            if (messageEncontrado.isEmpty()){
                return messageRepository.saveMessage(messageModel);
            }else {
                return messageModel;
            }
        }
    }
    public boolean deleteMessage(Integer id){
        Boolean respuesta = getMessage(id).map(elemento -> {
            messageRepository.deleteMessage(elemento.getIdMessage()); //
            return true;
        }).orElse(false);
        return respuesta;
    }
    public MessageModel updateMessage(MessageModel messageModel){
        if (messageModel.getIdMessage()!=null){
            Optional<MessageModel> messageEncontrado = getMessage(messageModel.getIdMessage());
            if (!messageEncontrado.isEmpty()){
                if (messageModel.getMessageText()!=null){
                    messageEncontrado.get().setMessageText(messageModel.getMessageText());
                    messageEncontrado.get().setClient(messageModel.getClient());
                    messageEncontrado.get().setBoat(messageModel.getBoat());
                    }
                }
                return messageRepository.saveMessage(messageEncontrado.get());
            }
        return messageModel;
    }
}
