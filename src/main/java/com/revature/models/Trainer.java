package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trainerId;
	private String name;
	@OneToMany(mappedBy="pokeId", fetch=FetchType.EAGER)
	private List<Pokemon> party;
	public Trainer() {
		super();
	}
	public Trainer(String name) {
		super();
		this.name = name;
	}
	public Trainer(String name, List<Pokemon> party) {
		super();
		this.name = name;
		this.party = party;
	}
	public Trainer(int trainerId, String name, List<Pokemon> party) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.party = party;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pokemon> getParty() {
		return party;
	}
	public void setParty(List<Pokemon> party) {
		this.party = party;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, party, trainerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		return Objects.equals(name, other.name) && Objects.equals(party, other.party) && trainerId == other.trainerId;
	}
	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", " + (name != null ? "name=" + name + ", " : "")
				+ (party != null ? "party=" + party : "") + "]";
	}
	
	
}
