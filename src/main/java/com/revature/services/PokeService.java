package com.revature.services;

import com.revature.models.Pokemon;
import com.revature.repos.PokeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokeService {

    private PokeDAO pokeDAO;

    @Autowired
    public PokeService(PokeDAO pokeDAO) {
        this.pokeDAO = pokeDAO;
    }

    public Pokemon getById(int id) {
        return pokeDAO.getById(id);
    }

    public void addOrUpdatePokemon(Pokemon pokemon) {
        pokeDAO.save(pokemon);
    }
}
