package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.services.PokeService;
import com.revature.services.TrainerService;


@RestController
@RequestMapping(path="/poke")
@CrossOrigin
public class PokemonController {
	
	private PokeService pokemonService;
	private TrainerService trainerService;
	
	@Autowired
	public PokemonController(PokeService pokemonService,TrainerService trainerService) {
		this.pokemonService=pokemonService;
		 this.trainerService = trainerService;
	}
	
	@PostMapping
	public ResponseEntity<List<Trainer>> addPokeToTrainer(@RequestBody Pokemon poke ) {
		pokemonService.addOrUpdatePokemon(poke);
		System.out.println("In addPoke: "+poke.toString());
		return ResponseEntity.status(201).body(trainerService.getAllTrainers());
	}
	
}
