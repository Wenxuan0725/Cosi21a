/**
 * This class defines the data structure of HashMap.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 12/5/2021
 * COSI 21a PA3
 */
package main;

public class HashMap {
	private Entry[] hashArray;
	private int size;
	private double numOfElement;
	private double loadFactor;
	
	/**
	 * This is the constructor of the class
	 * 
	 * Running time: O(1)
	 */
	public HashMap() {
		this.size=15;
		hashArray=new Entry[size];
	}
	
	/**
	 * This is the method to set an object into the HashMap
	 * @param key is a GraphNode needed to set into the HashMap
	 * @param value is the int needed to be set with the node
	 * @throws Exception Exception will be thrown if a node is failed to add into the hashMap
	 * 
	 * Running time: O(n)
	 */
	public void set(GraphNode key,int value) throws Exception {
		if(!hasKey(key)) {
			add(key,value);
		}else {
			int count=0;
			int location=hashFunction(key.getId(),count);
			while(!hashArray[location].getKey().getId().equals(key.getId())) {
				count++;
				location=hashFunction(key.getId(),count);
			}
			hashArray[location].setValue(value);
		}
	}
	
	/**
	 * This is the method to add an object into the HashMap
	 * @param key is a GraphNode needed to add into the HashMap
	 * @param value is the int needed to be set with the node
	 * @throws Exception Exception will be thrown if a node is failed to add into the hashMap
	 * 
	 * Running time: O(n)
	 */
	public void add(GraphNode key,int value) throws Exception {
		for(int i=0;i<=size;i++) {
			int location=hashFunction(key.getId(),i);
			if(hashArray[location]==null) {
				Entry temp=new Entry(key,value);
				hashArray[location]=temp;
				numOfElement++;
				this.loadFactor=numOfElement/size;
				check();
				return;
			}
		}
		throw new Exception("Fail to add");
	}
	
	/**
	 * This is a method creating a hash function
	 * @param id a string representing the ID of a place
	 * @param a an int representing the time to use hash function 
	 * @return an int representing the index of an object in the hash map
	 * 
	 * Running time: O(1)
	 */
	public int hashFunction(String id,int a) {
		int result=0;
		for(int i=0;i<=7;i++) {
			char temp=id.charAt(i);
			if(Character.isDigit(temp)) {
				result+=temp;
			}
		}
		result=(((result)%size)+((int)(a*a)%size))%size;
		return result;
	}
	
	/**
	 * This is a method to find the value of a node
	 * @param g the node needs to find value in the hash map
	 * @return an int which is they value of the node
	 * @throws Exception is thrown if the node g is not in the hash map
	 * 
	 * Running time: O(1)
	 */
	public int getValue(GraphNode g) throws Exception {
		if(hasKey(g)) {
			int count=0;
			int location=hashFunction(g.getId(),count);
			while(!hashArray[location].getKey().getId().equals(g.getId())) {
				count++;
				location=hashFunction(g.getId(),count);
			}
			return hashArray[location].getValue();
		}else {
			throw new Exception("key is not in the hash map");
		}
	}
	
	/**
	 * This is a method to check if the node is in the hash map
	 * @param g is the node needs to check
	 * @return boolean true if the node in the hash map, false otherwise
	 * 
	 * Running time: O(1)
	 */
	public boolean hasKey(GraphNode g) {
		for(int i=0;i<numOfElement;i++) {
			int location=hashFunction(g.getId(),i);
			if(hashArray[location]==null) {
				return false;
			}else if(hashArray[location].getKey().getId().equals(g.getId())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This is a method to rehashing the the hash map
	 * 
	 * Running time: O(n)
	 */
	public void check() {
		if(loadFactor>0.5) {
			this.size=size*2;
			loadFactor=numOfElement/size;
			Entry[] temp=new Entry[size];
			for(int i=0;i<hashArray.length;i++) {
				if(hashArray[i]!=null) {
					int count=0;
					int location=hashFunction(hashArray[i].getKey().getId(),count);
					while(temp[location]!=null) {
						count++;
						location=hashFunction(hashArray[i].getKey().getId(),count);
					}
					temp[location]=hashArray[i];
				}
			}
			hashArray=temp;
		}
	}
	
	/**
	 * This is a method to get the Entry array stored in the hash map
	 * @return an Entry array containing all those information
	 * 
	 * Running time: O(1)
	 */
	public Entry[] getArray() {
		return hashArray;
	}
}
