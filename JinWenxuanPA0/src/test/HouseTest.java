/**
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class tests object House
 * Known Bugs: N/A
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.House;

class HouseTest {

	House test=new House(3,1000,true);
	
	/**
	 * This is a test for methods in House class
	 */
	@Test
	void test() {
		assertEquals(3,test.getRooms());
		assertEquals(1000,test.getPrice());
		assertEquals(true,test.petsAllowed());
		assertEquals(""+3+" "+1000+" True",test.toString());
	}

}
