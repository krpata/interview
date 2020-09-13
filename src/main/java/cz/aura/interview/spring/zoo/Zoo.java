package cz.aura.interview.spring.zoo;

import cz.aura.interview.spring.zoo.animal.Animal;
import cz.aura.interview.spring.zoo.animal.Elephant;
import cz.aura.interview.spring.zoo.animal.Lion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class Zoo {

	@Autowired
	private List<Animal> animals;

	public Zoo(List<Animal> animals) {
		this.animals = animals;
	}

	public Zoo() {
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Lion> getLions() {
		return getAnimals()
				.stream()
				.filter(p -> p instanceof Lion)
				.map(p -> (Lion) p)
				.collect(Collectors.toList());
	}

	public List<Elephant> getElephants() {
		return getAnimals()
				.stream()
				.filter(p -> p instanceof Elephant)
				.map(p -> (Elephant) p)
				.collect(Collectors.toList());
	}
}
