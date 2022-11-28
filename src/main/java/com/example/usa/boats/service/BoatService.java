package com.example.usa.boats.service;

import com.example.usa.boats.model.BoatModel;
import com.example.usa.boats.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<BoatModel> getAllBoats(){
        return boatRepository.getAllBoats();
    }
    public Optional<BoatModel>getBoat(Integer id){
        return boatRepository.getBoat(id);
    }
    public BoatModel saveBoat(BoatModel boatModel){
        if(boatModel.getId()==null){
            return boatRepository.saveBoat(boatModel);
        }else {
            Optional<BoatModel> boatEncontrada = getBoat(boatModel.getId());
            if (boatEncontrada.isEmpty()){
                return boatRepository.saveBoat(boatModel);
            }else {
                return boatModel;
            }
        }
    }
    public boolean deleteBoat(Integer id){
        Boolean respuesta = getBoat(id).map(elemento -> {
            boatRepository.deleteBoat(elemento.getId()); //
            return true;
        }).orElse(false);
        return respuesta;
    }
    public BoatModel updateBoat(BoatModel boatModel){
        if (boatModel.getId()!=null){
            Optional<BoatModel> boatEncontrado = getBoat(boatModel.getId());
            if (!boatEncontrado.isEmpty()){
                if (boatModel.getName()!=null){
                    boatEncontrado.get().setName(boatModel.getName());
                }
                if (boatModel.getBrand()!=null){
                    boatEncontrado.get().setBrand(boatModel.getBrand());
                }
                if (boatModel.getYear()!=null){
                    boatEncontrado.get().setYear(boatModel.getYear());
                }
                if (boatModel.getDescription()!=null){
                    boatEncontrado.get().setDescription(boatModel.getDescription());
                }
                if (boatModel.getCategory()!=null){
                    boatEncontrado.get().setCategory(boatModel.getCategory());
                }
                return boatRepository.saveBoat(boatEncontrado.get());
            }
        }
        return boatModel;
    }
}
