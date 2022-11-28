package com.example.usa.boats.repository;

import com.example.usa.boats.model.BoatModel;
import com.example.usa.boats.repository.crudrepository.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {
    @Autowired
    private BoatCrudRepository boatCrudRepository ;

    public List<BoatModel> getAllBoats(){
        return (List<BoatModel>) boatCrudRepository.findAll();
    }

    public Optional<BoatModel> getBoat(Integer id){
        return boatCrudRepository.findById(id);
    }
    public BoatModel saveBoat(BoatModel boatModel){
        return boatCrudRepository.save(boatModel);
    }
    public boolean deleteBoat(Integer id){
        boatCrudRepository.deleteById(id);
        return true;
    }
    public BoatModel updateBoat(BoatModel boatModel){
        return boatCrudRepository.save(boatModel);
    }
}
