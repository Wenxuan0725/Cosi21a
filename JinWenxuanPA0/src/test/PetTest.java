/**
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This is a test class for object Pet
 * Known Bugs: N/A
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Pet;

class PetTest {
	Pet dog=new Pet("Lucy","Dog",5);
	Pet cat=new Pet("Max","Cat",8);
	Pet monkey=new Pet("Bella","Monkey",2);
	
	/**
	 * This is a test testing the constructor of 
	 */
	@Test
	void test() {
		assertEquals("Lucy",dog.getName());
		assertEquals("Dog",dog.getSpecies());
		assertEquals(5,dog.getAge());
		assertEquals("Bella",monkey.getName());
		assertEquals("Monkey",monkey.getSpecies());
		assertEquals(2,monkey.getAge());
	}
	
	/**
	 * This is a test for makeSound method
	 */
	@Test
	void testMakeSound() {
		assertEquals("bark!",dog.makeSound());
		assertEquals("meow!",cat.makeSound());
		assertEquals("squak!",monkey.makeSound());
	}
	
	/**
	 * This is a test for toString method
	 */
	@Test
	void testToString() {
		assertEquals("Lucy Dog 5",dog.toString());
		assertEquals("Max Cat 8",cat.toString());
		assertEquals("Bella Monkey 2",monkey.toString());
	}

}
