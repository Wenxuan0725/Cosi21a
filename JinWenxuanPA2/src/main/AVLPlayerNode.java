/**
 * This class defines the AVLtree data structure.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 11/4/2021
 * COSI 21a PA2
 */
package main;
/**
 * Your code goes in this file
 * fill in the empty methods to allow for the required
 * operations. You can add any fields or methods you want
 * to help in your implementations.
 */

public class AVLPlayerNode{
    private Player data;
    private double value;
    private AVLPlayerNode root;
    private AVLPlayerNode parent;
    private AVLPlayerNode leftChild;
    private AVLPlayerNode rightChild;
    private int rightWeight;
    private int balanceFactor;
    private int height;
    
    /**
     * This is the constructor of this class
     * @param data is a Player type variable storing the information about a player
     * @param value a double store in the tree node
     */
    public AVLPlayerNode(Player data,double value) {
        this.data=data;
        this.value=value;
        root=this;
        
    }
    
   /**
    * This is an insert helper to help insert a node
    * @param curr the node wants to be inserted
    * @param v a tree node which curr will add into
    */
    private void insert_helper(AVLPlayerNode curr, AVLPlayerNode v) {
    	if(v.leftChild==null&&curr.value<v.value) {
    		v.leftChild=curr;
    		curr.parent=v;
    		curr.root=v.root;
    		
    		curr.height=buildHeight(curr);
    		v.height=buildHeight(v);
    		
    		root.updateBalanceFactor();
    		
    		curr.rightWeight=curr.buildRightWeight();
    		v.rightWeight=v.buildRightWeight();
    		
    	}else if(v.rightChild==null&&curr.value>v.value) {
    		v.rightChild=curr;
    		curr.parent=v;
    		curr.root=v.root;
    		root.updateBalanceFactor();

    		
    		curr.rightWeight=curr.buildRightWeight();
    		v.rightWeight=v.buildRightWeight();
    	}else if(curr.value<v.value) {
    		insert_helper(curr,v.leftChild);
    	}else if(curr.value>v.value){
    		insert_helper(curr,v.rightChild);
    	}
    }
    
    //This should return the new root of the tree
    //make sure to update the balance factor and right weight
    //and use rotations to maintain AVL condition
    /**
     * This is a method to insert a node into a tree
     * @param newGuy the player information
     * @param value the player's value
     * @return the new root of the tree
     */
    public AVLPlayerNode insert(Player newGuy,double value){
    	AVLPlayerNode curr=new AVLPlayerNode(newGuy,value);
    	if(root==null) {
    		root=curr;
    		return root;
    	}else {
    		insert_helper(curr,root);
    		AVLPlayerNode temp=curr;
    		while(temp.parent!=null) {
    			if(Math.abs(temp.balanceFactor)>1) {
    				temp.reBalance();
    			}
    			temp=temp.parent;
    		}
    		if(Math.abs(balanceFactor)>1) {
				temp.reBalance();
			}
    	}
    	return root;
    }
    
    /**
     * This is a method to find the node with minimum value
     * @param a the root of a tree wants to find minimum
     * @return the node in the tree with minimum value
     */
    public AVLPlayerNode findMini(AVLPlayerNode a) {
    	while(a.leftChild!=null) {
    		a=a.leftChild;
    	}
    	return a;
    }
    
    /**
     * This is a method to find the node with maximum value
     * @param b the root of a tree wants to find maximum
     * @return the node in the tree with maximum value
     */
    public AVLPlayerNode findMax(AVLPlayerNode b) {
    	while(b.rightChild!=null) {
    		b=b.rightChild;
    	}
    	return b;
    }
    
    /**
     * This is a method to find the successor of current node
     * @param v current node
     * @return the successor of current node
     */
    private AVLPlayerNode successor(AVLPlayerNode v) {
    	if(v.rightChild!=null) {
    		return findMini(v.rightChild);
    	}else {
    		AVLPlayerNode temp=v.parent;
    		while(temp!=null&&temp==v.rightChild) {
    			v=temp;
    			temp=temp.parent;
    		}
    		return temp;
    	}
    }
    //This should return the new root of the tree
    //remember to update the right weight
    /**
     * This is a method to delete a node in a tree
     * @param value the value of the node needs to be deleted 
     * @return the new root after deleting 
     */
    public AVLPlayerNode delete(double value){
    	AVLPlayerNode deleteNode=root.getRank_helper(value);
    	if(deleteNode==null) {
    		return root;
    	}
    	AVLPlayerNode y;
    	AVLPlayerNode x;
    	if(deleteNode.leftChild==null||deleteNode.rightChild==null) {
    		y=deleteNode;
    	}else {
    		y=successor(deleteNode);
    	}
    	if(y.leftChild!=null) {
    		x=y.leftChild;
    	}else {
    		x=y.rightChild;
    	}
    	if(x!=null) {
    		x.parent=y.parent;
    	}
    	if(y.parent==null) {
    		root=x;
    		if(root!=null) {
    			root.updateRoot(root);
    		}
    		
    	}else {
    		if(y==y.parent.leftChild) {
    			y.parent.leftChild=x;
    		}else {
    			y.parent.rightChild=x;
    		}
    	}
    	if(y!=deleteNode) {
    		deleteNode.data=y.data;
    		deleteNode.value=y.value;
    	}
    	if(root==null) {
    		this.value=0;
    		this.data=null;
    	}
    	if(root!=null) {
    		root.updateBalanceFactor();
        	root.updateRightWeight();
    	}
    	deleteRebalance();
    	
    	return root;
    	
    }
    
    /**
     * This is a method to check if the tree need to rotate after deleting and rotate it if the tree needs
     */
    private void deleteRebalance () {
    	if(this.root==null) {
    		return;
    	}
    	AVLPlayerNode max=findMax(root);
    	AVLPlayerNode min=findMini(root);
    	while(min.parent!=null) {
			if(Math.abs(min.balanceFactor)>1) {
				min.reBalance();
			}
			min=min.parent;
		}
    	while(max.parent!=null) {
			if(Math.abs(max.balanceFactor)>1) {
				max.reBalance();
			}
			max=max.parent;
		}
    	if(Math.abs(max.balanceFactor)>1) {
			max.reBalance();
		}
    	
    }
    
    /**
     * This is a method to rebalance the tree through rotations
     */
    private void reBalance() {
    	if(balanceFactor<0) {
    		if(rightChild.balanceFactor>0) {
    			rightChild.rotateRight();
    			this.rotateLeft();
    		}else {
    			this.rotateLeft();
    		}
    	}else {
    		if(leftChild.balanceFactor<0) {
    			leftChild.rotateLeft();
    			this.rotateRight();
    		}else {
    			this.rotateRight();
    		}
    	}
    	
    }
    
    /**
     * This is a method to update the root of a tree for all nodes
     * @param root the new root
     */
    private void updateRoot(AVLPlayerNode root) {
    	if(this!=null) {
      		this.root=root;
    	}
    	if(this.leftChild!=null) {
    		leftChild.updateRoot(root);
    	}
    	if(this.rightChild!=null) {
    		rightChild.updateRoot(root);
    	}
    }
    //remember to maintain rightWeight
    /**
     * This is a method to let the tree rotate right
     */
    private void rotateRight(){
    	AVLPlayerNode y=leftChild;
    	leftChild=y.rightChild;
    	if(y.rightChild!=null) {
    		y.rightChild.parent=this;
    	}
    	y.parent=parent;
    	if(parent==null) {
    		root=y;
    		if(root!=null) {
    			root.updateRoot(root);
    		}
    	}else if(this==parent.rightChild) {
    		parent.rightChild=y;
    	}else {
    		parent.leftChild=y;
    	}
    	y.rightChild=this;
    	parent=y;
    	root.updateBalanceFactor();
    	root.updateRightWeight();
    }

    //remember to maintain rightWeight
    /**
     * This is a method to let the tree rotate left
     */
    private void rotateLeft(){
    	AVLPlayerNode y=rightChild;
    	rightChild=y.leftChild;
    	if(y.leftChild!=null) {
    		y.leftChild.parent=this;
    	}
    	y.parent=parent;
    	if(parent==null) {
    		root=y;
    		if(root!=null) {
    			root.updateRoot(root);
    		}
    	}else if(this==parent.leftChild) {
    		parent.leftChild=y;
    	}else {
    		parent.rightChild=y;
    	}
    	y.leftChild=this;
    	parent=y;
    	root.updateBalanceFactor();
    	root.updateRightWeight();
    }
    
    /**
     * This is a method to update each node's balanceFactor 
     * @return the updated balanceFactor
     */
    private int updateBalanceFactor() {
    	if(this.leftChild==null&&this.rightChild==null) {
    		balanceFactor=0;
    		return 0;
    		
    	}else if(this.leftChild==null) {
    		balanceFactor=-1-buildHeight(rightChild);
    		return balanceFactor;
    	}else if(this.rightChild==null) {
    		balanceFactor=buildHeight(leftChild)+1;
    		return balanceFactor;
    	}else {
    		balanceFactor=buildHeight(leftChild)-buildHeight(rightChild);
    		leftChild.updateBalanceFactor();
    		rightChild.updateBalanceFactor();
    		return balanceFactor;
    	}
    }
    
    /**
     * This is a helper method to getPlayer
     * @param value the value of the node want to be found
     * @return the target player with that value 
     */
    private Player getPlayer_helper(double value) {
    	if(data==null) {
    		return null;
    	}
    	if(this.value==value) {
    		return data;
    	}else {
    		if(leftChild!=null&&this.value>value) {
    			return leftChild.getPlayer_helper(value);
    		}else if(rightChild!=null&&this.value<value){
    			return rightChild.getPlayer_helper(value);
    		}else {
    			return null;
    		}
    	}
    }
	
    //this should return the Player object stored in the node with this.value == value
    /**
     * This is a method to return a Player with the target value
     * @param value the value of the node want to be found
     * @return the target player with that value 
     */
    public Player getPlayer(double value){
    	return root.getPlayer_helper(value);
    }
    
    /**
     * This is a helper to getRank to find the node with target value
     * @param value the target value wanted to be found in a node
     * @return the node with the value
     */
    private AVLPlayerNode getRank_helper(double value) {
    	if(data==null) {
    		return null;
    	}
    	if(this.value==value) {
    		return this;
    	}else {
    		if(leftChild!=null&&this.value>value) {
    			return leftChild.getRank_helper(value);
    		}else if(rightChild!=null&&this.value<value){
    			return rightChild.getRank_helper(value);
    		}else {
    			return null;
    		}
    	}
    }
   
    /**
     * This is a method to find the rank of a node in right subtree
     * @param value the value of a node
     * @return the rank of a node with value equals the input value
     */
    private int getRightRank(double value) {
    	if(this.value==value&&parent!=null&&value>parent.value&&value>root.value&&leftChild==null&&rightChild==null) {
    		return 1;
    	}
    	if(this.value>value&&leftChild==null&&rightChild==null) {
    		return 1;
    	}else {
    		if(rightChild!=null&&this!=root&&parent!=root&&this.value<parent.value) {
    			return 1+rightChild.getRightRank(value)+this.parent.getRightRank(value);
    		}else {
    			int temp=0;
    			if(leftChild!=null&&leftChild.value>value) {
    				temp+=1+leftChild.getLeftRank(value);
    			}
    			if(rightChild!=null) {
    				temp+=1+rightChild.getRightRank(value);
    			}
    			if(parent!=null&&parent.value>this.value) {
    				temp+=1+parent.getRightRank(value);
    			}
    			return temp;
    		}

    	}
    }
    
    /**
     * This is a method to find the rank of a node in left subtree
     * @param value the value of a node
     * @return the rank of a node in the left subtree of root with value equals the input value
     */
    private int getLeftRank(double value) {
    	if(this==root) {
    		return 0;
    	}
    	if(rightChild==null&&leftChild==null) {
    		return 0;
    	}else {
    		if(rightChild!=null&&rightChild.value>this.value) {
    			return 1+rightChild.getRightRank(value)+this.parent.getLeftRank(value);
    		}else{
    			return 1+parent.getLeftRank(value);
    		}
    	}
    }
    
    //this should return the rank of the node with this.value == value
    /**
     * This is a method to find a node
     * @param value the value of a node wants to find rank
     * @return the rank of target node
     */
    public int getRank(double value){
    	AVLPlayerNode temp=root.getRank_helper(value);
    	if(temp==null) {
    		return 0;
    	}
        if(value>root.value) {
        	return temp.getRightRank(temp.value);
        }else if(value<root.value){
        	return root.getRightRank(temp.value)+temp.getLeftRank(temp.value);
        }else {
        	return root.getRightRank(temp.value);
        }
    }

    //this should return the tree of names with parentheses separating subtrees
    //eg "((bob)alice(bill))"
    /**
     * This is a method to format a tree's information
     * @return a string with the information of a tree
     */
    public String treeString() {
    	if(root!=null) {
    		return root.treeStringHelper();
    	}
    	else {
    		return null;
    	}
    }
    
    /**
     * This is a helper to treeString to format the information of a tree
     * @return a string with the information of a tree
     */
    public String treeStringHelper() {
    	if(leftChild==null&&rightChild==null) {
    		return "("+data.getName()+")";
    	}else if(leftChild==null){
    		return "("+data.getName()+rightChild.treeStringHelper()+")";
    	}else if(rightChild==null) {
    		return "("+leftChild.treeStringHelper()+data.getName()+")";
    	}else {
    		return "("+leftChild.treeStringHelper()+this.data.getName()+rightChild.treeStringHelper()+")";
    	}
    }

    //this should return a formatted scoreboard in descending order of value
    //see example printout in the pdf for the command L
    /**
     * This is a method to format a scoreboard
     * @return a string containing required information
     */
    public String scoreboard(){
    	String result="";
    	if(root==null) {
    		result=String.format("%-10s", "NAME")+String.format("%-4s", "ID")+String.format("%-10s", "SCORE")+"\n";
    		return result;
    	}else {
    		result=root.visit(result);
    		result=String.format("%-10s", "NAME")+String.format("%-4s", "ID")+String.format("%-10s", "SCORE")+"\n"+result;
    		return result;
    	}
    	
    	
    }
    
    /**
     * This is a helper method to scoreBoard to format a score board
     * @param result a string which already contains some information
     * @return a string with the current node information
     */
    private String visit(String result) {
    	if(rightChild==null&&leftChild==null) {
    		result=result+String.format("%-10s", this.data.getName())+String.format("%-4s", this.data.getID())+String.format("%.2f", this.data.getELO())+"\n";
    		return result;
    	}
    	else {
    		if(rightChild!=null) {
        		result=rightChild.visit(result);
        	}
        	result+=String.format("%-10s", this.data.getName())+String.format("%-4s", this.data.getID())+String.format("%.2f", this.data.getELO())+"\n";
        	if(leftChild!=null) {
        		result=leftChild.visit(result);
        	}
        	return result;
    	}
    	
    }
    
    /**
     * This is method to get the value of a node
     * @return a double which is the value of a node
     */
    public double getValue() {
    	return value; 
    }
    
    /**
     * This is a method to calculate a node's height
     * @param v the node wants to find height
     * @return the height of the node
     */
    private int buildHeight(AVLPlayerNode v) {
    	if(v==null) {
    		return -1;
    	}else {
    		return 1+Math.max(buildHeight(v.rightChild),buildHeight(v.leftChild));
    	}
    }
    
    /**
     * This is a method to update rightWeight field when there is a rotation occur
     */
    private void updateRightWeight() {
    	if(rightChild==null||leftChild==null) {
    		return;
    	}else {
    		rightWeight=this.buildRightWeight();
    		leftChild.updateRightWeight();
    		rightChild.updateRightWeight();
    	}
    }
    
    /**
     * This is a method to build a node's rightWeight
     * @return the rightWeight of a node
     */
    private int buildRightWeight() {
    	if(rightChild==null) {
    		return 0;
    	}else {
    		return rightChild.buildRightWeight()+1;
    	}
    }
    
  
    /**
     * This is a toString method 
     * @return a string representing information about the tree
     */
    public String toString() {
    	if(root==null) {
    		return null;
    	}else {
    		return root.treeString();
    	}
    }
	
}
    
	
