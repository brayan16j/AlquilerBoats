package com.example.usa.boats.service;

import com.example.usa.boats.model.ClientModel;
import com.example.usa.boats.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<ClientModel> getAllClients(){
        return clientRepository.getAllClients();
    }
    public Optional<ClientModel>getClient(Integer id){
        return clientRepository.getClient(id);
    }
    public ClientModel saveClient(ClientModel clientModel){
        if (clientModel.getIdClient() == null) {
            return clientRepository.saveClient(clientModel);
        }else {
            Optional<ClientModel> clientEncontrado = getClient(clientModel.getIdClient());
            if (clientEncontrado.isEmpty()){
                return clientRepository.saveClient(clientModel);
            }else {
                return clientModel;
            }
        }
    }
    public boolean deleteClient(Integer id){
        Boolean respuesta = getClient(id).map(elemento -> {
            clientRepository.deleteClient(elemento.getIdClient()); //
            return true;
        }).orElse(false);
        return respuesta;
    }
    public ClientModel updateClient(ClientModel clientModel){
        if (clientModel.getIdClient()!=null) {
            Optional<ClientModel> clienteEncontrado = getClient(clientModel.getIdClient());
            if (!clienteEncontrado.isEmpty()) {
                if (clientModel.getName() != null) {
                    clienteEncontrado.get().setName(clientModel.getName());
                }
                if (clientModel.getAge() != null) {
                    clienteEncontrado.get().setAge(clientModel.getAge());
                }
                if (clientModel.getPassword() != null) {
                    clienteEncontrado.get().setPassword(clientModel.getPassword());
                }
                return clientRepository.saveClient(clienteEncontrado.get());
            }
        }
        return clientModel;
    }

}
