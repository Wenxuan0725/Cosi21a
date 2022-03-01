/**
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class define an object House and some related methods
 * Known Bugs: N/A
 */

package main;

public class House {
	
	private int rooms;
	private int price;
	private boolean petsAllowed;
	
	/**
	 * Creates a House object with the given rooms, price, and petsAllowed
	 * @param rooms number of rooms in a house
	 * @param price price of the house
	 * @param petsAllowed whether the house allows pets
	 */
	public House(int rooms, int price, boolean petsAllowed) {
		this.rooms=rooms;
		this.price=price;
		this.petsAllowed=petsAllowed;
	}
	
	/**
	 * returns the rooms of this House
	 * @return an integer representing the rooms of this House
	 */
	public int getRooms() {
		return rooms;
	}
	
	/**
	 * returns the price of this House
	 * @return an integer representing the price of this House
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * returns whether the house allows pets
	 * @return boolean representing whether the house allows pets
	 */
	public boolean petsAllowed() {
		return petsAllowed;
	}
	
	/**
	 * returns a String representation of this House, including room, price, and petsAllowed
	 * @return a String representation of this House
	 */
	public String toString() {
		String result="";
		if(petsAllowed) {
			result=""+rooms+" "+price+" True";
		}else {
			result=rooms+" "+price+" False";
		}
		return result;
		
	}
}

