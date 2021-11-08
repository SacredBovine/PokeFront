package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Pokemon;

public interface PokeDAO extends JpaRepository<Pokemon, Integer> {
	
}
