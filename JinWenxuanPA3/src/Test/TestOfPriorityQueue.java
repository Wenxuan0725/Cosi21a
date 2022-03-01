package Test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import main.GraphNode;
import main.MinPriorityQueue;
public class TestOfPriorityQueue {
	@Test
	public void testCase1() throws Exception {
		GraphNode test1=new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91",false);
		GraphNode test2=new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb9",false);
		GraphNode test3=new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a",false);
		GraphNode test4=new GraphNode("a6725faf-3aac-414e-8d3a-58ab6adab2db",false);
		GraphNode test5=new GraphNode("7e885935-2923-42f9-acdc-d6e65ea172e6",false);
		GraphNode test6=new GraphNode("aebf38ed-55f4-493e-9e2a-2f78394beb69",false);
		GraphNode test7=new GraphNode("0a8b7dc8-fa38-49d2-bba4-3184651da8cc",false);
		GraphNode test8=new GraphNode("1fd618f2-e519-4eb2-b4d3-05273641854c",false);
		GraphNode test9=new GraphNode("fe30169b-655f-430e-a437-2b4892e7abfd",false);
		test1.priority=10;
		test2.priority=12;
		test3.priority=9;
		test4.priority=7;
		test5.priority=5;
		test6.priority=6;
		test7.priority=4;
		test8.priority=8;
		test9.priority=1;
		MinPriorityQueue test=new MinPriorityQueue();
		test.insert(test1);
		test.insert(test2);
		test.insert(test3);
		test.insert(test4);
		test.insert(test5);
		test.insert(test6);
		test.insert(test7);
		test.insert(test8);
		test.insert(test9);
		int temp=test.pullHighestPriorityElement().priority;
		assertEquals(1,temp);
		test1.priority=0;
		test.rebalance(test1);
		assertEquals(0,test.pullHighestPriorityElement().priority);
		
	}
}
