package cz.aura.interview.spring.zoo.animal;

import cz.aura.interview.spring.zoo.animal.enums.Gender;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Lion implements Animal {

	private String name;

	private int age;

	private Gender gender;

	private Date birthDate;
	
	private Set<Lion> children = new HashSet<>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	@Required
	public void setAge(int age) {
		this.age = age;
	}

	public Set<Lion> getChildren() {
		return children;
	}

	public void setChildren(Set<Lion> children) {
		this.children = children;
	}

	@Required
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public Gender getGender() {
		return gender;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}
}
