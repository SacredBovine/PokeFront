package com.revature.services;

import com.revature.models.Trainer;
import com.revature.repos.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private TrainerDAO trainerDAO;

    @Autowired
    public TrainerService(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    public List<Trainer> getAllTrainers() {
        return trainerDAO.findAll();
    }

    public Trainer getById(int id) {
        return trainerDAO.getById(id);
    }

    public void addOrUpdateTrainer(Trainer trainer) {
        trainerDAO.save(trainer);
    }
}
