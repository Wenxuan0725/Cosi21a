/**
 * This class defines the Node
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> prev;
	
	/**
	 * This is the constructor of the class
	 * @param element data needs to be stored in the node
	 * 
	 * Running time:O(1)
	 */
	public Node(T element) {
		data=element;
		next=null;
		prev=null;
	}
	
	/**
	 * This is a method to set the data in the node
	 * @param element the data need to set in the node
	 * 
	 * Running time:O(1)
	 */
	public void setElement(T element) {
		data=element;
	}
	
	/**
	 * This is a method to set the next of current node
	 * @param next a node which will be the next of this node
	 * 
	 * Running time:O(1)
	 */
	public void setNext(Node<T> next) {
		this.next=next;
	}
	
	/**
	 * This is a method to set the previous of the current node
	 * @param prev a node which will be the previous of this node
	 * 
	 * Running time:O(1)
	 */
	public void setPrev(Node<T> prev) {
		this.prev=prev;
	}
	
	/**
	 * This is a method to get the next node
	 * @return the next node
	 * 
	 * Running time:O(1)
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * This is a method to get the previous node
	 * @return the previous node
	 * 
	 * Running time:O(1)
	 */
	public Node<T> getPrev() {
		return prev;
	}
	
	/**
	 * This is a method to get the data stored in current node
	 * @return the data stored in current node
	 * 
	 * Running time:O(1)
	 */
	public T getElement() {
		return data;
	}
	
	/**
	 * This is a method to return the information of current node
	 * @return a string representing the information of current node
	 */
	@Override
	public String toString() {
		return ""+data;
	}
}
