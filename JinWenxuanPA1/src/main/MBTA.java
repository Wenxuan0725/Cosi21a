/**
 * This class is the main class running the program
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	/**
	 * This is the main class to run the program
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * Running time: O(n^2)
	 */
	public static void main(String[] args) throws FileNotFoundException {
		r=new Railway();
		Scanner console=new Scanner(System.in);
		System.out.println("What is the name of the trainsFile?");
		String trainsFile=console.nextLine();
		System.out.println("What is the name of the ridersFile?");
		String ridersFile=console.nextLine();
		System.out.println("What is the name of the stationsFile?");
		String stationsFile=console.nextLine();
		initStations(stationsFile);
		initRiders(ridersFile);
		initTrains(trainsFile);
		
		runSimulation();
	}
	
	/**
	 * This is a method to runStimulation
	 * 
	 * Running time: O(TIMES*n^2)
	 */
	public static void runSimulation() {
		String result="";
		for(int i=0;i<TIMES;i++) {
			result+=r.simulate();
		}
		System.out.println(result);
	}
	
	/**
	 * This is a method to initialize trains
	 * @param trainsFile the name of the file which will be read
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * 
	 * Running time: O(n^2)
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		Scanner console=new Scanner(new File(trainsFile));
		while(console.hasNext()) {
			String station=console.nextLine();
			int direction=console.nextInt();
			console.nextLine();
			Train a =new Train(station,direction);
			r.addTrain(a);
		}
	}
	
	/**
	 * This is a method to initialize riders
	 * @param ridersFile the name of the file which will be read
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * 
	 * Running time: O(n^2)
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		Scanner console=new Scanner(new File(ridersFile));
		while(console.hasNextLine()) {
			String ID=console.nextLine();
			String starting=console.nextLine();
			String destination=console.nextLine();
			Rider a=new Rider(ID,starting,destination);
			r.addRider(a);
			
		}
	}
	
	/**
	 * This is a method to initialize stations
	 * @param stationsFile the name of the file which will be read
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * 
	 * Running time: O(n^2)
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		Scanner console=new Scanner(new File(stationsFile));
		while(console.hasNextLine()) {
			Station temp=new Station(console.nextLine());
			r.addStation(temp);
		}
	}
}
