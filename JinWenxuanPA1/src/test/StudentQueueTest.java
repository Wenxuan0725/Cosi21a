/**
 * This Junit test is used to test queue
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

import main.Queue;

class StudentQueueTest {
	Queue test=new Queue(10);

	@Test
	void test() {
		test.enqueue(100);
		assertEquals(test.size(),1);
		test.enqueue(1000);
		assertEquals(test.front(),100);
		test.dequeue();
		assertEquals(test.front(),1000);
		assertEquals(test.toString(),"1000");
	}

}
