/**
 * This Junit test is used to test double Linked list
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;

class StudentDLLTest {
	DoubleLinkedList temp=new DoubleLinkedList();

	@Test
	void test1() {
		temp.insert(100);
		temp.insert(200);
		temp.insert(300);
		assertEquals(temp.toString(),"100,200,300");
		assertEquals(temp.get(100),100);
		assertEquals(temp.getFirst().toString(),"100" );
		assertEquals(temp.size(),3);
	}
	
	@Test
	void test2() {
		temp.insert(100);
		temp.insert(200);
		temp.insert(300);
		assertEquals(temp.toString(),"100,200,300");
		assertEquals(temp.delete(200),200);
		temp.insert(400);
		assertEquals(temp.toString(),"100,300,400");
	}
	

}
