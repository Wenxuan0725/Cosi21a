/**
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class define an object Person and some related methods
 * Known Bugs: N/A
 */

package main;

/**
 * NOTE: This class has provided sample Javadoc comments for you. 
 *       In all other classes you must include your own Javadocs.
 *
 */
public class Person {
	
	private String name;
	private int age;
	private int salary;
	
	/**
	 * Creates a Person object with the given name, age, and salary
	 * @param name the name of the Person to be created
	 * @param age the age of the Person to be created
	 * @param salary the salary of the Person to be created
	 */
	public Person(String name, int age, int salary) {
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
	/**
	 * returns the name of this Person 
	 * @return a String representing the name of this Person
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the age of this Person
	 * @return an integer representing the age of this Person
	 */
	public int getAge() {
		return age;
	}

	/**
	 * returns the salary of this Person
	 * @return an integer representing the salary of this Person
	 */
	public int getSalary() {
		return salary;
	}
	
	/**
	 * returns the string said by this Person when they speak
	 * @return String representation of what this Person says
	 */
	public String speak() {
		if(age<=18) {
			return "I want a bigger house!";
		}else {
			return "This house does not have enough rooms to accommodate my family. "
					+ "I would like my family to be assigned to a house with more rooms.";
		}
	}
	
	/**
	 * returns a String representation of this Person, including name, age, and salary
	 * @return a String representation of this Person 
	 */
	@Override
	public String toString() {
		return ""+name+" "+age+" "+salary;
	}
}

