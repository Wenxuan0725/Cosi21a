/**
 * This class test the AVLtree data structure.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 11/4/2021
 * COSI 21a PA2
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.AVLPlayerNode;
import main.Player;

class TestTree {

	@Test
	public void testCase1() {
		Player wendy=new Player("Wendy",100,10);
		Player tom=new Player("Tom",150,15);
		Player amy=new Player("Amy",99,9);
		Player amber=new Player("Amber",175,13);
		Player alex=new Player("Alex",125,11);
		Player jack=new Player("Jack",130,14);
		AVLPlayerNode test=new AVLPlayerNode(wendy,100);
		test.insert(tom,150);
		test.insert(amy, 99);
		test.insert(amber, 175);
		test.insert(alex, 125);
		assertEquals("((Amy)Wendy((Alex)Tom(Amber)))",test.treeString());	
		test.insert(jack, 130);
		assertEquals(wendy,test.getPlayer(100));
		assertEquals(amber,test.getPlayer(175));
		assertEquals("(((Amy)Wendy)Alex((Jack)Tom(Amber)))",test.treeString());
		assertEquals("Amy",test.getPlayer(99).getName());
		assertEquals(3,test.getRank(130));
		assertEquals(4,test.getRank(125));
		assertEquals(5,test.getRank(100));
		assertEquals(6,test.getRank(99));
		test=test.delete(150);
		assertEquals("(((Amy)Wendy)Alex((Jack)Amber))",test.treeString());
		test=test.delete(125);
		assertEquals("(((Amy)Wendy)Jack(Amber))",test.treeString());
		assertEquals("NAME      ID  SCORE     \n" + 
				"Amber     175 13.00\n" + 
				"Jack      130 14.00\n" + 
				"Wendy     100 10.00\n" + 
				"Amy       99  9.00\n",test.scoreboard());
	}
	
	@Test
	public void testCase2() {
		AVLPlayerNode test=new AVLPlayerNode (new Player("Wendy",100,10),100);
		test=test.delete(100);
		assertEquals(null,test);
		
	}
	
	

}
