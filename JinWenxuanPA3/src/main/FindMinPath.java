/**
 * This class is to find the minimum path.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 12/5/2021
 * COSI 21a PA3
 */
package main;

import java.io.File;
import java.io.PrintStream;

public class FindMinPath {
	/**
	 * This is the main method run the class
	 * @param args is the algorithm run the class
	 * @throws Exception is thrown if a new file cannot be created
	 * 
	 * Running time: O(nlogn)
	 */
	 public static void main(String[] args) throws Exception{
		 MinPriorityQueue Q=new MinPriorityQueue();
		 GraphWrapper gw=new GraphWrapper(false);
		 GraphNode home=gw.getHome();
		 home.priority=0;
		 Q.insert(home);
		 GraphNode result=run(Q);//using run method to find the min path
		 PrintStream output=new PrintStream(new File("output.txt"));
		 String res="";
		 while(result!=null&&!result.getId().equals(home.getId())) {
			 res=result.previousDirection+"\n"+res;
			 result=result.previousNode;
		 }
		 output.println(res);//print result into a file
		 
	 }
	 
	 /**
	  * This is the main method to run the find min path
	  * @param Q this is the priority queue containing all path information
	  * @return the node of the terminus
	  * @throws Exception Exception will be thrown if a node is failed to add into the hashMap
	  * 
	  * O(nlogn)
	  */
	 public static GraphNode run(MinPriorityQueue Q) throws Exception{
		 while(!Q.isEmpty()) {
			 GraphNode curr=Q.pullHighestPriorityElement();
			 if(curr.isGoalNode()) {
				 return curr;
			 }else {
				 if(curr.hasEast()) {
					 int x=curr.priority+curr.getEastWeight();
					 GraphNode east=curr.getEast();
					 if(!Q.find(east)&&east.priority==0) {
						 east.priority=x;
						 east.previousNode=curr;
						 east.previousDirection="East";
//						 east.getWest().priority=-1;
						 Q.insert(east);
					 }else if(Q.find(east)){
						 if(east.priority>x) {
							 east.priority=x;
							 Q.rebalance(east);
							 east.previousNode=curr;
							 east.previousDirection="East";
//							 east.getWest().priority=-1;
						 }
					 }
				 }
				 if(curr.hasWest()) {
					 int x=curr.priority+curr.getWestWeight();
					 GraphNode west=curr.getWest();
					 if(!Q.find(west)&&west.priority==0) {
						 west.priority=x;
						 west.previousNode=curr;
						 west.previousDirection="West";
//						 west.getEast().priority=-1;
						 Q.insert(west);
					 }else if(Q.find(west)){
						 if(west.priority>x) {
							 west.priority=x;
							 Q.rebalance(west);
							 west.previousNode=curr;
							 west.previousDirection="West";
//							 west.getEast().priority=-1;
						 }
					 }
				 }
				 if(curr.hasSouth()) {
					 int x=curr.priority+curr.getSouthWeight();
					 GraphNode south=curr.getSouth();
					 if(!Q.find(south)&&south.priority==0) {
						 south.priority=x;
						 south.previousNode=curr;
						 south.previousDirection="South";
//						 south.getNorth().priority=-1;
						 Q.insert(south);
					 }else if(Q.find(south)){
						 if(south.priority>x) {
							 south.priority=x;
							 Q.rebalance(south);
							 south.previousNode=curr;
							 south.previousDirection="South";
//							 south.getNorth().priority=-1;
						 }
					 }
				 }
				 if(curr.hasNorth()) {
					 int x=curr.priority+curr.getNorthWeight();
					 GraphNode north=curr.getNorth();
					 if(!Q.find(north)&&north.priority==0) {
						 north.priority=x;
						 north.previousNode=curr;
						 north.previousDirection="North";
//						 north.getSouth().priority=-1;
						 Q.insert(north);
					 }else if(Q.find(north)){
						 if(north.priority>x) {
							 north.priority=x;
							 Q.rebalance(north);
							 north.previousNode=curr;
							 north.previousDirection="North";
//							 north.getSouth().priority=-1;
						 }
					 }
				 }
			 }
			 curr.priority=-1;//avoid infinite loop
		 }
		 return null;
	 }
}
