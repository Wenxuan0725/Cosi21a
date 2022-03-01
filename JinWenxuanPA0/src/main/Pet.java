/**
 * * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class define an object Pet and some related methods.
 * Known Bugs: N/A
 */

package main;

public class Pet {
	
	private String name;
	private String species;
	private int age;
	
	/**
	 * Creates a Pet object with the given name, species, and age
	 * @param name the name of the Pet to be created
	 * @param species the species of the Pet to be created
	 * @param age the age of the Pet to be created
	 */
	public Pet(String name, String species, int age) {
		this.name=name;
		this.species=species;
		this.age=age;
	}
	
	/**
	 * returns the name of this Pet
	 * @return a String representing the name of this Pet
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the species of this Pet
	 * @return an String representing the species of this Pet
	 */
	public String getSpecies() {
		return species;
	}
	
	/**
	 * returns the age of this Pet
	 * @return an integer representing the age of this Pet
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * returns the string said by this Pet when they make sound
	 * @return String representation of what this Pet says
	 */
	public String makeSound() {
		if(species.equals("Dog")) {
			return "bark!";
		}else if(species.equals("Cat")) {
			return "meow!";
		}else {
			return "squak!";
		}
	}
	
	/**
	 * returns a String representation of this Pet, including name, species and age
	 * @return a String representation of this Pet
	 */
	@Override
	public String toString() {
		return ""+name+" "+species+" "+age;
	}
}

