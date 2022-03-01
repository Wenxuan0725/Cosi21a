/**
 * * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class tests Object Family
 * Known Bugs: N/A
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Family;
import main.Person;
import main.Pet;

class FamilyTest {
	Family home=new Family(3,1);
	Person a=new Person("Wendy",18,1000);
	Person b=new Person("Jack",40,50000);
	Person c=new Person("Yan",35,50000);
	Pet dog=new Pet("Lucy","Dog",5);
	boolean people1=home.addMember(a);
	boolean people2=home.addMember(b);
	boolean people3=home.addMember(c);
	boolean pet1=home.addPet(dog);
	Person[] test1= {a,b,c};
	Pet[] test2={dog};
	int budget=1000+50000+50000;
	
	/**
	 * This is a test for getPeople method
	 */
	@Test
	void testGetPeople() {
		assertEquals(test1[1],home.getPeople()[1]);
	}
	
	/**
	 * This is a test for getPets method
	 */
	@Test
	void testGetPets() {
		assertEquals(test2[0],home.getPets()[0]);
	}
	
	/**
	 * This is a test for getBudget method
	 */
	@Test
	void testGetBudget() {
		assertEquals(budget,home.getBudget());
	}
	
	/**
	 * This is a test for numberOfPets and numberOfPeople methods
	 */
	@Test
	void testNumber() {
		assertEquals(3,home.numberOfPeople());
		assertEquals(1,home.numberOfPets());
	}
	
	/**
	 * This is a test for toString method
	 */
	@Test
	void testToString() {
		assertEquals(""+3+" "+1+" "+budget+"\n"+"Wendy "+18+" "+1000+"\n"+"Jack "+40+" "+50000+"\n"+"Yan "+35+" "+50000+"\n"+"Lucy Dog "+5+"\n",home.toString());
	}

}
