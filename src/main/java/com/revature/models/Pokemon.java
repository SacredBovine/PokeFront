package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pokeId;
	private int pokedexId;
	private String name;
	private int baseXP;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="trainerId" )
	@JsonIgnore
	private Trainer trainer;
	public Pokemon() {
		super();
	}
	public Pokemon(int pokedexId, String name, int baseXP, Trainer trainer) {
		super();
		this.pokedexId = pokedexId;
		this.name = name;
		this.baseXP = baseXP;
		this.trainer = trainer;
	}
	public Pokemon(int pokeId, int pokedexId, String name, int baseXP, Trainer trainer) {
		super();
		this.pokeId = pokeId;
		this.pokedexId = pokedexId;
		this.name = name;
		this.baseXP = baseXP;
		this.trainer = trainer;
	}
	public int getPokeId() {
		return pokeId;
	}
	public void setPokeId(int pokeId) {
		this.pokeId = pokeId;
	}
	public int getPokedexId() {
		return pokedexId;
	}
	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBaseXP() {
		return baseXP;
	}
	public void setBaseXP(int baseXP) {
		this.baseXP = baseXP;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(baseXP, name, pokeId, pokedexId, trainer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return baseXP == other.baseXP && Objects.equals(name, other.name) && pokeId == other.pokeId
				&& pokedexId == other.pokedexId && Objects.equals(trainer, other.trainer);
	}
	@Override
	public String toString() {
		return "Pokemon [pokeId=" + pokeId + ", pokedexId=" + pokedexId + ", "
				+ (name != null ? "name=" + name + ", " : "") + "baseXP=" + baseXP + ", "
				+ (trainer != null ? "trainer=" + trainer : "") + "]";
	}
	
	
}
