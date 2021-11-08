package com.revature.controllers;


import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trainers")
@CrossOrigin
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable("id") int id) {
        Trainer trainer = trainerService.getById(id);
        return ResponseEntity.status(200).body(trainer);
    }

    @PostMapping
    public ResponseEntity<List<Trainer>> addTrainer(@RequestBody Trainer trainer) {
        trainerService.addOrUpdateTrainer(trainer);
        
        return ResponseEntity.status(201).body(trainerService.getAllTrainers());
    }
    


    @PutMapping
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) {
        trainerService.addOrUpdateTrainer(trainer);
        return ResponseEntity.status(200).build();
    }
}
