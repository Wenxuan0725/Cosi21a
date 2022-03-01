/**
 * This class defines the double linked list data structure.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

public class DoubleLinkedList<T> {
	
	public Node<T> head;
	public Node<T> tail;
	public int num;
	
	/**
	 * This is the constructor of the class
	 * 
	 * Running time: O(1)
	 */
	public DoubleLinkedList() {
		head=new Node<T>(null);
		tail=new Node<T>(null);
		head.next=tail;
		tail.prev=head;
		num=0;
		
	}
	
	/**
	 * This is a method get the first node in the linked list
	 * @return the first node
	 * 
	 * Running time: O(1)
	 */
	public Node<T> getFirst() {
		return head;
	}
	
	/**
	 * This is a method to insert an element at the end of an linked list
	 * @param element the element we need to put into the list 
	 * 
	 * Running time: O(1)
	 */
	public void insert(T element) {
		Node<T> temp=new Node<T>(element);
		if(head.data==null) {
			head.data=element;
		}else {
			temp.prev=tail.prev;
			temp.next=tail;
			tail.prev.next=temp;
			tail.prev=temp;
		}
		num++;
	}
	
	/**
	 * This is a method to delete the element key in the linked list 
	 * @param key the element we want to delete in the linked list
	 * @return the deleted element or null if that element is not in the list
	 * 
	 * Running time: O(n)
	 */
	public T delete(T key) {
		Node<T>curr=head;
		while(curr.next!=null) {
			if(curr.data.equals(key)) {
				curr.prev.next=curr.next;
				curr.next.prev=curr.prev;
				num--;
				return curr.data;
			}
			curr=curr.next;
		}
		if(curr.data==key) {
			tail.prev=curr.prev;
			curr.prev.next=tail;
			num--;
			return curr.data;
		}
		return null;
	}
	
	/**
	 * This is a get method to get an element in the linked list.
	 * @param key the element we want to get in the linked list
	 * @return the element which is equals key or null if the element does not exist
	 * 
	 * Running time: O(n)
	 */
	public T get(T key) {
		Node<T>curr=head;
		while(curr!=null) {
			if(curr.data==key) {
				return curr.data;
			}
			curr=curr.next;
		}
		return null;
	}
	
	public int size() {
		return num;
	}
	
	/**
	 * This is a method to print information in a linked list
	 * @return the String contains information about the linked list
	 * 
	 * Running time: O(1)
	 */
	@Override
	public String toString() {
		Node<T>curr=head;
		String result="";
		while(curr.next!=null) {
			result+=curr.toString()+",";
			curr=curr.next;
		}
		result=result.substring(0,result.length()-1);
		return result;
	}
}
