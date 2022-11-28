package com.example.usa.boats.repository;

import com.example.usa.boats.model.ScoreModel;
import com.example.usa.boats.repository.crudrepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<ScoreModel> getAll() {
        return (List<ScoreModel>) scoreCrudRepository.findAll();
    }

    public Optional<ScoreModel> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public ScoreModel save(ScoreModel scoreModel){
        return scoreCrudRepository.save(scoreModel);
    }

    public void delete (ScoreModel scoreModel){
        scoreCrudRepository.delete(scoreModel);
    }
}
