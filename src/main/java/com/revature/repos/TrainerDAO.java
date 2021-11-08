package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Trainer;

public interface TrainerDAO extends JpaRepository<Trainer, Integer>{

}
