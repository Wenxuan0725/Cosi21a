/**
 * This class defines the object railway.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/20/2021
 * COSI 21a PA1
 */
package main;

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	public int num;
	
	/**
	 * This is a constructor of the class
	 * 
	 * Running time: O(1)
	 */
	public Railway() {
		railway=new DoubleLinkedList<Station>();
		stationNames=new String[18];
		num=0;
		
	}
	
	/**
	 * This is a method to add a station into railway
	 * @param s the station needs to be added
	 * 
	 *  Running time: O(1)
	 */
	public void addStation(Station s) {
		stationNames[num]=s.stationName();
		railway.insert(s);
		num++;
	}
	
	/**
	 * This is a method to add a rider into the railway
	 * @param r the rider needs to be added
	 * 
	 * Running time: O(n)
	 */
	public void addRider(Rider r) {
		setRiderDirection(r);
		String starting=r.getStarting();
		Node<Station> curr=railway.getFirst();
		while(curr.next!=null) {
			if(curr.data.stationName().equals(starting)) {//check if the rider's starting station is this station
				curr.data.addRider(r);
			}
			curr=curr.next;
		}
		
	}
	
	/**
	 * This is a method to add a train to the railway
	 * @param t the train needs to be add
	 * 
	 * Running time: O(n)
	 */
	public void addTrain(Train t) {
		String current=t.currentStation;
		Node<Station> curr=railway.getFirst();
		while(curr.next!=null) {
			if(curr.data.stationName().equals(current)) {//check if the train's station is this station
				curr.data.addTrain(t);
			}
			curr=curr.next;
		}
	}
	
	/**
	 * This is a method to check whether a rider's direction is correct and correct it if there is something wrong
	 * @param r the rider need to set direction
	 * 
	 * Running time: O(n)
	 */
	public void setRiderDirection(Rider r) {
		boolean start=false;
		boolean destination=false;
		for(int i=0;i<num;i++) {
			if(stationNames[i].equals(r.getStarting())) {//
				start=true;
			}else if(stationNames[i].equals(r.getDestination())) {
				destination=true;
			}
			if(start&&destination==false) {//if the starting station is before the destination
				if(r.goingNorth()) {
					r.swapDirection();
				}
				return;
			}else if(destination&&start==false) {//if the destination is before the starting station
				if(!r.goingNorth()) {
					r.swapDirection();
				}
				return;
			}
		}
	}
	
	/**
	 * This is a method to stimulate trains to running
	 * @return a string representing operating information
	 * 
	 * Running time:O(n^2)
	 */
	public String simulate() {
		String result="";
		Node<Station> curr=railway.getFirst();
		while(curr.data!=null) {
			Station temp=curr.getElement();
			result+=temp.toString()+"\n";
			Queue<Train> south=temp.southBoundTrains;
			Queue<Train> north=temp.northBoundTrains;
			boolean southcheck=false;
			boolean northcheck=false;
			if(south.front()!=null) {//if the station has a train going to south
				if(temp.stationName().equals("Braintree")) {//if the station is the south most one
					southcheck=true;
				}else {
					Train data=temp.southBoardTrain();
					temp=curr.next.getElement();
					data.updateStation(temp.stationName());
					result+=temp.addTrain(data)+"\n";
				}
			}
			temp=curr.getElement();
			if(north.front()!=null) {//check if the station has train moving to north
				if(temp.stationName().equals("Alewife")) {//check if the station's name is the north most one
					northcheck=true;
				}else {
					Train data=temp.northBoardTrain();
					temp=curr.prev.getElement();
					data.updateStation(temp.stationName());
					result+=temp.addTrain(data)+"\n";
					
					
				}	
			}
			if(southcheck) {
				temp=curr.getElement();
				temp.moveTrainSouthToNorth();
			}
			if(northcheck) {
				temp=curr.getElement();
				temp.moveTrainNorthToSouth();
			}
			curr=curr.next;
		}
		return result;
	}
	
	/**
	 * This is a method to return information about the railway
	 * @return a string containing information about the railway
	 * 
	 * Running time:O(n)
	 */
	@Override
	public String toString() {
		String result="";
		Node<Station> curr=railway.getFirst();
		while(curr.next!=null) {
			result+=curr.data.toString();
			curr=curr.next;
		}
		return result;
	}
}
