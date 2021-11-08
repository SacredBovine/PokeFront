package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class PokemonController {
	
	private PokeService pokemonService;
	private TrainerService trainerService;
	
	@Autowired
	public PokemonController(PokeService pokemonService) {
		this.pokemonService=pokemonService;
	}
	
	@PostMapping
	public ResponseEntity<Pokemon> addPokeToTrainer(@RequestBody Pokemon poke ) {
		pokemonService.addOrUpdatePokemon(poke);
		return ResponseEntity.status(201).build();
	}
	
}
