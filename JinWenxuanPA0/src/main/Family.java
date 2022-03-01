/**
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class define an object Family and some related methods
 * Known Bugs: N/A
 */

package main;

public class Family {
	
	private Person[] familyMembers;
	private Pet[] familyPets;
	
	/**
	 * Creates a Family object with the given number of humans and pets.
	 * @param humans number of humans in the family
	 * @param pets number of pets in the family
	 */
	public Family(int humans, int pets) {
		familyMembers=new Person[humans];
		familyPets=new Pet[pets];
	}
	
	/**
	 * returns all family members
	 * @return the array of family members
	 */
	public Person[] getPeople() {
		return familyMembers;
	}
	
	/**
	 * returns all family pets
	 * @return the array of family pets
	 */
	public Pet[] getPets() {
		return familyPets;
	}
	
	/**
	 * calculates and returns the budget of the family
	 * @return an integer of the family budget
	 */
	public int getBudget() {
		int budget=0;
		for(int i=0;i<familyMembers.length;i++) {
			budget+=familyMembers[i].getSalary();
		}
		return budget;
	}
	
	/**
	 * returns the number of people in the family
	 * @return an integer representing the number of people in the family
	 */
	public int numberOfPeople() {
		return familyMembers.length;
	}
	
	/**
	 * returns the number of pets in the family
	 * @return an integer representing the number of pets in the family
	 */
	public int numberOfPets() {
		return familyPets.length;
	}
	
	/**
	 * adds a person into the family
	 * @param p the person who will be added
	 * @return a boolean representing whether add the person into the family successfully
	 */
	public boolean addMember(Person p) {
		for(int i=0;i<familyMembers.length;i++) {
			if(familyMembers[i]==null) {
				familyMembers[i]=p;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * adds a pet into the family
	 * @param p the pet who will be added
	 * @return a boolean representing whether add the pet into the family successfully
	 */
	public boolean addPet(Pet p) {
		for(int i=0;i<familyPets.length;i++) {
			if(familyPets[i]==null) {
				familyPets[i]=p;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * returns a String representation of this family
	 * @return a String representation of this family
	 */
	@Override
	public String toString() {
		String result=""+numberOfPeople()+" "+numberOfPets()+" "+getBudget()+"\n";
		for(int i=0;i<familyMembers.length;i++) {
			result+=familyMembers[i].toString()+"\n";
		}
		for(int i=0;i<familyPets.length;i++) {
			result+=familyPets[i].toString()+"\n";
		}
		return result;
	}
	
}

