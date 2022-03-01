/**
 * This class defines the queue data structure.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	/**
	 * This is the constructor for the queue class
	 * @param capacity the maximum size of the queue
	 * 
	 * Running time: O(1)
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		head=0;
		tail=0;
		numEntries=0;
	}
	
	/**
	 * This is a method to put an element into a queue
	 * @param element the element which needs to be added into the queue
	 * 
	 * Running time: O(1)
	 */
	public void enqueue(T element) {
		q[tail]=element;
		if(tail==q.length-1) {
			if(head!=0) {
				tail=0;
			}else {
				throw new NoSuchElementException("The queue is full");
			}
		}else {
			tail++;
		}
		numEntries++;
	}
	
	/**
	 * This is a method to the first element in to queue
	 * 
	 * Running time: O(1)
	 */
	public void dequeue() {
		if(q==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		if(head==q.length-1) {
			head=0;
		}else {
			head++;
		}
		numEntries--;
		
	}
	
	/**
	 * This is a method return the first or top element of the queue
	 * @return the first element in the queue
	 * 
	 * Running time: O(1)
	 */
	public T front() {
		return q[head];
	}
	
	/**
	 * This is a method to return the numbers of elements in the queue
	 * @return an integer representing the numbers of elements
	 */
	public int size() {
		return numEntries;
	}
	
	/**
	 * This is a method to return a string contains all information in the queue
	 * @return a string representing all information
	 * 
	 * Running time: O(1) 
	 */
	@Override
	public String toString() {
		String result="";
		int count=head;
		for(int i=0;i<numEntries-1;i++) {
			if(count==q.length-1) {
				count=0;
			}
			result+=q[count]+",";
			count++;
		}
		result+=q[count];
		return result;
	}
}
