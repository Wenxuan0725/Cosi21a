/**
 * This class defines the data structure of MinPriorityQueue extends from heap.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 12/5/2021
 * COSI 21a PA3
 */
package main;

public class MinPriorityQueue extends Heap{
	
	/**
	 * This is the constructor of the class
	 * 
	 * Running time: O(1)
	 */
	public MinPriorityQueue() {
		super(20);
	}
	
	/**
	 * This is a method to insert a graphNode object into the priority queue
	 * @param g a graphNode needs to insert into the heap
	 * @throws Exception will be thrown if a node is failed to add into the hashMap
	 * 
	 * Running time: O(logn) 
	 */
	public void insert(GraphNode g) throws Exception {
		super.insert(g);
	}
	
	/**
	 * This is a method to delete the node with highest priority in the priority queue
	 * @return the deleted node
	 * @throws Exception is thrown if the heap is empty
	 * 
	 * Running time: O(logn)
	 */
	public GraphNode pullHighestPriorityElement() throws Exception {
		return super.deleteMin();
	}
	
	/**
	 * This is a method to rebalance the priority queue
	 * @param g the graphNode needs to heapify up
	 * @throws Exception is thrown if the node g is not in the hash map
	 * 
	 * Running time: O(logn)
	 */
	public void rebalance(GraphNode g) throws Exception {
		super.heapify_up(g);
	}
	
	/**
	 * This is a method to check if the priority queue is empty
	 * @return boolean, true if the priority queue is empty, false otherwise
	 * 
	 * O(1)
	 */
	public boolean isEmpty() {
		return super.isEmpty();
	}
}
