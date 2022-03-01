package Test;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import main.GraphNode;
import main.HashMap;

public class TestOfHashMap {
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
		HashMap test=new HashMap();
		test.set(test1, 1);
		test.set(test2, 2);
		test.set(test3, 3);
		test.set(test4, 4);
		test.set(test5, 5);
		test.set(test6, 6);
		assertEquals(test.getArray().length,15);
		test.set(test7, 7);
		test.set(test8, 8);
		assertEquals(test.getArray().length,30);
		test.set(test9, 9);
		assertEquals(test.getValue(test9),9);
		assertEquals(test.getArray()[1].getKey(),test2);
		assertEquals(test.getArray()[2].getKey(),test4);
		assertEquals(test.getArray()[19].getKey(),test8);
		assertEquals(test.getArray()[17].getKey(),test6);
	}
}
