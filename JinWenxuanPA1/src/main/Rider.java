/**
 * This class defines the Rider object.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

public class Rider {
	public String riderID;
	public String startingStation;
	public String destinationStation;
	public int direction;

	/**
	 * This is a constructor of the class
	 * @param riderID a string containing a rider's ID
	 * @param startingStation a string recording the start station of a rider
	 * @param destinationStation a string recording the destination station of a rider
	 * 
	 * Running time: O(1)
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID=riderID;
		this.startingStation=startingStation;
		this.destinationStation=destinationStation;
		direction=1;
	}
	
	/**
	 * This is a method get the starting station of the rider
	 * @return the starting station of the rider
	 * 
	 * Running time: O(1)
	 */
	public String getStarting() {
		return startingStation;
	}
	
	/**
	 * This is a method get the destination of the rider
	 * @return a string which is the destination station of the rider
	 * 
	 * Running time: O(1)
	 */
	public String getDestination() {
		return destinationStation;
	}
	
	/**
	 * This is a method get the ID of a rider
	 * @return a string which is the ID of the rider
	 * 
	 * Running time: O(1)
	 */
	public String getRiderID() {
		return riderID;
	}
	
	/**
	 * This is a method to check whether the rider is going to the north
	 * @return boolean true if the the rider is going to north, otherwise false
	 * 
	 * Running time: O(1)
	 */
	public boolean goingNorth() {	
		if(direction==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to swap a rider's direction
	 * 
	 * Running time: O(1)
	 */
	public void swapDirection() {
		if(direction==1) {
			direction=0;
		}else {
			direction=1;
		}
	}
	
	/**
	 * This is a method to return the information of a rider
	 * @return a string record rider's information
	 * 
	 * Running time:O(1)
	 */
	@Override
	public String toString() {
		String temp="";
		if(direction==1) {
			temp="south";
		}else {
			temp="north";
		}
		return riderID+","+startingStation+","+destinationStation+","+temp;
	}
	
	/**
	 * This is a method to check whether two riders are the same
	 * @param an object need to be checked
	 * @return boolean true if two objects are same, otherwise false
	 * 
	 * Running time: O(1)
	 */
	@Override
	public boolean equals(Object s) {
		if(s instanceof Rider) {
			if(((Rider) s).riderID.equals(riderID)) {
				return true;
			}
		}
		return false;
	}
}
