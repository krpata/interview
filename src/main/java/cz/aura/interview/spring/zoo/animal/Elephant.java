package cz.aura.interview.spring.zoo.animal;

import cz.aura.interview.spring.zoo.animal.enums.Gender;

public class Elephant implements Animal {
	
	private String name;
	
	private int age;
	
	private Gender gender;
	
	private Elephant mother;

	private Elephant father;
	
	public Elephant(String name, int age, Gender gender, Elephant mother, Elephant father) {
		this(age, name, gender, mother, father);
	}

	public Elephant(String name, int age, Gender gender) {
		this(age, name, gender, null, null);
	}
	
	public Elephant(int age, String name, Gender gender) {
		this(age, name, gender, null, null);
	}

	public Elephant(int age, String name, Gender gender, Elephant mother, Elephant father) {
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.mother = mother;
		this.father = father;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	public Elephant getMother() {
		return mother;
	}

	public Elephant getFather() {
		return father;
	}
	
}
