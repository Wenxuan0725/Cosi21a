/**
 * This class defines the data structure of heap.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 12/5/2021
 * COSI 21a PA3
 */
package main;

public class Heap {
	protected GraphNode[] data;
	protected int queueSize;
	protected int size;
	
	protected HashMap hashMap;
	
	/**
	 * This is the constructor of the class
	 * @param size the size of the heap
	 * 
	 * Running time: O(1)
	 */
	public Heap(int size) {
		this.queueSize=1;
		this.size=size;
		data=new GraphNode[size];
		hashMap=new HashMap();
	}

	/**
	 * This is a method to insert a graphNode object into the heap
	 * @param g a graphNode needs to insert into the heap
	 * @throws Exception will be thrown if a node is failed to add into the hashMap
	 * 
	 * Running time: O(logn) 
	 */
	public void insert(GraphNode g) throws Exception {
		if(queueSize+1==size) {
			resize();
		}
		data[queueSize]=g;
		hashMap.set(g,queueSize);
		queueSize++;
		heapify_up(g);
	}
	
	/**
	 * This is a method to heapify up a graphNode
	 * @param g the graphNode needs to heapify up
	 * @throws Exception is thrown if the node g is not in the hash map
	 * 
	 * Running time: O(logn)
	 */
	public void heapify_up(GraphNode g) throws Exception {
		int index=hashMap.getValue(g);
		while(getParent(index)>0&&data[getParent(index)].priority>g.priority) {
			swap(g,index);
			index=getParent(index);
		}
		
	}
	
	/**
	 * This is a method to delete the minimum element in the heap
	 * @return the deleted node
	 * @throws Exception is thrown if the heap is empty
	 * 
	 * Running time: O(logn)
	 */
	public GraphNode deleteMin()throws Exception {
		if(queueSize<1) {
			throw new Exception("Empty Queue");
		}
		GraphNode temp=data[1];
		queueSize--;
		data[1]=data[queueSize];
		hashMap.set(data[1], 1);
		heapify_down(data[1]);
		return temp;
	}
	
	/**
	 * This is a method to heapify down a graphNode
	 * @param g the graphNode needs to heapify down
	 * @throws Exception is thrown if the node g is not in the hash map
	 * 
	 * Running time: O(logn)
	 */
	public void heapify_down(GraphNode g) throws Exception {
		int index=hashMap.getValue(g);
		GraphNode small=g;
		if(getLeft(index)<queueSize&&data[getLeft(index)].priority<small.priority) {
			small=data[getLeft(index)];
		}
		if(getRight(index)<queueSize&&data[getRight(index)].priority<small.priority) {
			small=data[getRight(index)];
		}
		if(!small.getId().equals(g.getId())) {
			swap(g,small);
			heapify_down(g);
		}
	}
	
	/**
	 * This is a method to check if the heap is empty
	 * @return boolean, true if the heap is empty, false otherwise
	 * 
	 * O(1)
	 */
	public boolean isEmpty() {
		if(queueSize<1) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to get the index of the parent of a node
	 * @param index the index of the current node
	 * @return the index of parent node
	 * 
	 * Running time: O(1)
	 */
	public int getParent(int index) {
		return index/2;
	}
	
	/**
	 * This is a method to get the index of the right child
	 * @param index the index of the current node
	 * @return the index of right child
	 * 
	 * Running time: O(1)
	 */
	public int getRight(int index) {
		return 2*index+1;
	}
	
	/**
	 * This is a method to get the index of the left child
	 * @param index the index of the current node
	 * @return the index of left child
	 * 
	 * Running time: O(1)
	 */
	public int getLeft(int index) {
		return 2*index;
	}
	
	/**
	 * This is a method to swap the current graohNode and its parent
	 * @param g the current graphNode 
	 * @param index the index of current graphNode in the heap
	 * @throws Exception will be thrown if a node is failed to add into the hashMap
	 * 
	 * Running time: O(1)
	 */
	public void swap(GraphNode g,int index) throws Exception {
		GraphNode temp=data[getParent(index)];
		data[getParent(index)]=g;
		data[index]=temp;
		hashMap.set(g, getParent(index));
		hashMap.set(temp, index);
	}
	
	/**
	 * This is a method to swap two nodes in the heap
	 * @param g one of the graphNode need to be swapped
	 * @param small the other one graphNode
	 * @throws Exception will be thrown if a node is failed to add into the hashMap
	 * 
	 * Running time: O(1)
	 */
	public void swap(GraphNode g,GraphNode small) throws Exception {
		int index1=hashMap.getValue(g);
		int index2=hashMap.getValue(small);
		GraphNode temp=data[index1];
		data[index1]=data[index2];
		data[index2]=temp;
		hashMap.set(g,index2);
		hashMap.set(small,index1);
	}
	
	/**
	 * This is a method to resize the heap
	 * 
	 * Running time: O(n)
	 */
	public void resize() {
		size=size*2;
		GraphNode[] temp=new GraphNode[size]; 
		for(int i=1;i<data.length;i++) {
			temp[i]=data[i];
		}
		data=temp;
	}
	
	/**
	 * This is a method to print information stored in heap
	 * @return a string containing that information
	 * 
	 * Running time: O(n)
	 */
	public String toString() {
		String result="[";
		for(int i=1;i<queueSize;i++) {
			result+=data[i].priority+" ";
		}
		result+="]";
		return result;
	}
	
	/**
	 * This is a method to check if a graphNode is in heap
	 * @param g the graphNode needs to be checked
	 * @return boolean, true if the graphNode is in the heap, false otherwise
	 * 
	 * Running time: O(n)
	 */
	public boolean find(GraphNode g) {
		for(int i=1;i<queueSize;i++) {
			if(data[i].getId().equals(g.getId())) {
				return true;
			}
		}
		return false;
	}
}
