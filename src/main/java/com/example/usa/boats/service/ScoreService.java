package com.example.usa.boats.service;

import com.example.usa.boats.model.ScoreModel;
import com.example.usa.boats.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAllScore(){
        return scoreRepository.getAll();
    }
    public Optional<ScoreModel> getScore(Integer id){
        return scoreRepository.getScore(id);
    }
    public ScoreModel saveScore(ScoreModel scoreModel){
        if (scoreModel.getIdScore() == null) {
            return scoreRepository.save(scoreModel);
        }else {
            Optional<ScoreModel> scoreEncontrado = getScore(scoreModel.getIdScore());
            if (scoreEncontrado.isEmpty()){
                return scoreRepository.save(scoreModel);
            }else {
                return scoreModel;
            }
        }
    }
public ScoreModel updateScore(ScoreModel scoreModel){
        if (scoreModel.getIdScore()!=null){
            Optional<ScoreModel> scoreEncontrado = getScore(scoreModel.getIdScore());
            if (!scoreEncontrado.isEmpty()){
                if (scoreModel.getMessageText()!=null){
                    scoreEncontrado.get().setMessageText(scoreModel.getMessageText());
                }
                if (scoreModel.getStars()!=null){
                    scoreEncontrado.get().setStars(scoreModel.getStars());
                }
                return scoreRepository.save(scoreEncontrado.get());
            }
        }
        return scoreModel;
    }
    public boolean deleteScore(Integer id){
        Boolean respuesta = getScore(id).map(elemento -> {
            scoreRepository.delete(elemento); //
            return true;
        }).orElse(false);
        return respuesta;
    }

}
