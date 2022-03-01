/**
 * This class defines the object Entry.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 12/5/2021
 * COSI 21a PA3
 */
package main;

public class Entry {
	private GraphNode key;
	private int value;
	
	/**
	 * This is the constructor of the class
	 * @param key this is a graphNode containing path information
	 * @param value this is an int of the node have
	 * 
	 * Running time: O(1)
	 */
	public Entry(GraphNode key, int value) {
		this.key=key;
		this.value=value;
	}
	
	/**
	 * This is a method to return the information of a key
	 * @return the graphNode of the key
	 * 
	 * Running time: O(1)
	 */
	public GraphNode getKey () {
		return key;
	}
	
	/**
	 * This is a method to set a new value to the node
	 * @param newValue an int representing new key
	 * 
	 * Running time: O(1)
	 */
	public void setValue(int newValue) {
		this.value=newValue;
	}
	
	/**
	 * This is method to return the value of the graphNode
	 * @return the value of the graphNode
	 * 
	 * Running time: O(1)
	 */
	public int getValue() {
		return value;
	}
}
