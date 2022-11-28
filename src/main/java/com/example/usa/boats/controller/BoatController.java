package com.example.usa.boats.controller;

import com.example.usa.boats.model.BoatModel;
import com.example.usa.boats.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*")
public class BoatController {
    @Autowired
    private BoatService boatService;
    @GetMapping("/all")
    public List<BoatModel> getAllBoats(){
        return boatService.getAllBoats();
    }
    @GetMapping("/{idBoat}")
    public Optional<BoatModel> getBoat(@PathVariable("id")Integer id){
        return boatService.getBoat(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel saveBoat(@RequestBody BoatModel boatModel){
        return boatService.saveBoat(boatModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel updateBoat(@RequestBody BoatModel boatModel){
        return boatService.updateBoat(boatModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return boatService.deleteBoat(id);
    }
}
