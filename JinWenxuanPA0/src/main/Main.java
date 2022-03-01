/**
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 2/15/2021
 * PA0
 * This class is the main class operating the program
 * Known Bugs: N/A
 */

package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	/**
	 * There are three fields in the main class
	 * f is a 1-D array contains families
	 * h is a 1-D array contains houses
	 * assignments is a 2-D array contains assigning condition
	 */
	public static Family[] f;
	public static House[] h;
	public static boolean[][] assignments;
	
	/**
	 * This is the main class running the program 
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throw an exception if the document cannot be found on computer
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner family=new Scanner(new File("familyUnits.txt"));
		Scanner house=new Scanner(new File("housingUnits.txt"));
		createFamilies(family);
		createHomes(house);
		assignFamiliesToHomes();
		displayAssignments();
		for(int i=0;i<f.length;i++) {
			checkAssignment(i);
		}
	}
	
	/**
	 * This is a method creating families
	 * @param s is a scanner of a file containing family information
	 */
	public static void createFamilies(Scanner s) {
		if(s.hasNextInt()) {
			int size=s.nextInt();
			f=new Family[size];
			for(int i=0;i<size;i++) {//this is a for loop reach each family
				int numOfPeople=s.nextInt();
				int numOfPet=s.nextInt();
				f[i]=new Family(numOfPeople,numOfPet);
				s.nextLine();
				for(int j=0;j<numOfPeople;j++) {//this is a for loop running until reach all family members in a family.
					String[] data=new String[3];
					data=s.nextLine().split(" ");//split a family member's information using " "
					Person p=new Person(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
					boolean a=f[i].addMember(p);
					if(a==false) {
						throw new ArrayIndexOutOfBoundsException("familyMembers out of bound");
					}
				}
				for(int j=0;j<numOfPet;j++) {//this is a for loop running until reach all pets in a family.
					String[] data=s.nextLine().split(" ");//split a pet's information using " "
					Pet p=new Pet(data[0],data[1],Integer.parseInt(data[2]));
					boolean a=f[i].addPet(p);
					if(a==false) {
						throw new ArrayIndexOutOfBoundsException("familyPets out of bound");
					}
				}
			}
			
		}
		
		
	}
	
	/**
	 * This is a method creating houses
	 * @param s is a scanner of a file containing house information
	 */
	public static void createHomes(Scanner s) {
		if(s.hasNext()) {
			int size=s.nextInt();
			h=new House[size];
			for(int i=0;i<size;i++) {//This is a for loop record all house information into an array
				h[i]=new House(s.nextInt(),s.nextInt(),s.nextBoolean());
			}
			
		}
	}
	
	/**
	 * This is a method assign families to appropriate houses
	 */
	public static void assignFamiliesToHomes() {
		assignments=new boolean[f.length][h.length];
		boolean[] house=new boolean[h.length];
		for(int i=0;i<assignments.length;i++) {//this is a double for loop to reach all space of a 2-D array
			boolean assigned=false;//using a boolean to check whether the family is assigned or not
			for(int j=0;j<assignments[0].length;j++) {
				if(assigned==false) {//if the family is not assigned yet
					int numOfPeople=f[i].numberOfPeople();
					int numOfpet=f[i].numberOfPets();
					int budget=f[i].getBudget();
					int rooms=h[j].getRooms();
					int price=h[j].getPrice();
					boolean pet=h[j].petsAllowed();
					if(numOfPeople<=rooms&&budget>=price) {//compare basic information of a family and a house
						if(numOfpet>0&&pet&&house[j]==false) {
							assignments[i][j]=true;
							assigned=true;
							house[j]=true;
						}else if(numOfpet==0&&house[j]==false) {
							assignments[i][j]=true;
							assigned=true;
							house[j]=true;
						}
					}
				}
				
				
			}
		}
	}
	
	/**
	 * This is a method to print the condition of assignment
	 */
	public static void displayAssignments() {
		for(int i=0;i<assignments.length;i++) {
			boolean a=false;//using a boolean to check whether the family is assigned to a house or not
			for(int j=0;j<assignments[0].length;j++) {//this is a double for loop to reach all space of a 2-D array
				if(assignments[i][j]==true) {
					String result=f[i].toString()+h[j].toString();
					System.out.println(result);
					System.out.println();
					a=true;
				}
			}
			if(a==false) {
				String result=f[i].toString()+"not assigned to home\n";
				System.out.println(result);
			}
		}
	}
	
	/**
	 * This is a method to check whether there is any error occuring during assignment
	 * @param familyIndex
	 */
	public static void checkAssignment(int familyIndex) {
		int budget=f[familyIndex].getBudget();
		int numOfPeople=f[familyIndex].numberOfPeople();
		int numOfPet=f[familyIndex].numberOfPets();
		int houseIndex=-1;
		int times=0;
		for(int i=0;i<assignments[0].length;i++) {
			if(assignments[familyIndex][i]) {//find the index of the house assigned to a family
				houseIndex=i;
				times++;
			}
		}
		if(houseIndex!=-1) {
			int rooms=h[houseIndex].getRooms();
			int price=h[houseIndex].getPrice();
			boolean petAllowed=h[houseIndex].petsAllowed();
			if(rooms<numOfPeople) {//judge whether the rooms is fewer than the number of family number
				for(int i=0;i<numOfPeople;i++) {
					System.out.println(f[familyIndex].getPeople()[i].speak());
				}
			}
			if(numOfPet>0&&petAllowed==false) {//judge whether the house allows pets and whether the family has pets
				for(int i=0;i<numOfPet;i++) {
					System.out.println(f[familyIndex].getPets()[i].makeSound());
				}
			}
			if(budget<price) {//judge whether the price of the house can be paid by the family
				System.out.println("house over budget");
			}
			if(times>1) {//judge whether the family is assigned to more than one house.
				System.out.println("family assigned to more than one house");
			}
		}
	}
	
	
	

}

