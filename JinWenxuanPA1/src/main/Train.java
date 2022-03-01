/**
 * This class defines the train object.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	public int direction;
	public String currentStation;
	
	/**
	 * This is the constructor of the class
	 * @param currentStation a string representing the current station of the train
	 * @param direction an integer representing the direction of the train
	 * 
	 * Running time: O(1)
	 */
	public Train(String currentStation, int direction) {
		this.currentStation=currentStation;
		this.direction=direction;
		passengers=new Rider[TOTAL_PASSENGERS];
		passengerIndex=0;
	}
	
	/**
	 * This is a method to check whether the train is going to north
	 * @return boolean true if the the train going north, otherwise false
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
	 * This is a method swapping direction of the train
	 * 
	 * Running time:O(1)
	 */
	public void swapDirection() {
		if(direction==0) {
			direction=1;
		}else {
			direction=0;
		}
	}
	
	/**
	 * This is a method to get the current passengers on the train
	 * @return a string with the information of passengers
	 * 
	 * Running time: O(n)
	 */
	public String currentPassengers() {
		String result="";
		for(int i=0;i<passengerIndex;i++) {
			result+=passengers[i].getRiderID()+","+passengers[i].getDestination()+"\n";
		}
		return result;
	}
	
	/**
	 * This is a method to add a rider into the train
	 * @param r the rider will be added
	 * @return boolean showing whether it is added successfully
	 * 
	 * Running time: O(1)
	 */
	public boolean addPassenger(Rider r) {
		if(r!=null&&r.startingStation.equals(currentStation)&&r.direction==direction&&hasSpaceForPassengers()) {
			passengerIndex++;
			passengers[passengerIndex-1]=r;
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to check whether there is still space for passengers
	 * @return boolean true if there is still have space
	 * 
	 * Running time: O(1)
	 */
	public boolean hasSpaceForPassengers() {
		if(passengerIndex<TOTAL_PASSENGERS) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to make passengers get off
	 * @return a result return information of those get off passengers
	 * 
	 * Running time:O(n)
	 */
	public String disembarkPassengers() {
		String result="";
		boolean check=false;
		for(int i=0;i<passengerIndex;i++) {
			if(passengers[i].destinationStation.equals(currentStation)) {
				check=true;
				result+=passengers[i].getRiderID()+"\n";
				passengers[i]=passengers[passengerIndex-1];
				passengerIndex--;
				i--;
				
			}
		}
		if(check==false) {
			return result;
		}
		String temp="";
		if(direction==1) {
			temp="south";
		}else {
			temp="north";
		}
		result+="Direction: "+temp+"\n"+"Passengers: \n";
		for(int i=0;i<passengerIndex;i++) {
			result+=passengers[i].getRiderID()+","+passengers[i].getDestination()+"\n";
		}
		result+="Current station: "+currentStation+"\n";
		return result;
	}
	
	/**
	 * This is a method to update station information
	 * @param s a string representing the new station information
	 * 
	 * Running time: O(1)
	 */
	public void updateStation(String s) {
		currentStation=s;
	}
	
	/**
	 * This is a method to get the station the train located
	 * @return a string about the station
	 * 
	 * Running time: O(1)
	 */
	public String getStation() {
		return currentStation;
	}
	
	/**
	 * This is a method to return the information of the train
	 * @return a string representing train's information
	 * 
	 *  Running time: O(1)
	 */
	@Override
	public String toString() {
		String temp="";
		if(direction==1) {
			temp="south";
		}else {
			temp="north";
		}
		return ""+passengerIndex+","+currentStation+","+temp;
	}
}
