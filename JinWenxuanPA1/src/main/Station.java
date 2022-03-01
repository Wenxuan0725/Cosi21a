/**
 * This class defines the station object.
 * Known Bugs: N/A
 * 
 * Wenxuan Jin
 * wenxuanjin@brandeis.edu
 * 3/21/2021
 * COSI 21a PA1
 */
package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	public String name;
	
	/**
	 * This is the constructor of the class
	 * @param name a string of the name of the station
	 * 
	 * Running time:O(1)
	 */
	public Station(String name) {
		this.name=name;
		northBoundRiders=new Queue<Rider>(20);
		southBoundRiders=new Queue<Rider>(20);
		northBoundTrains=new Queue<Train>(20);
		southBoundTrains=new Queue<Train>(20);
	}
	
	/**
	 * This is a method to a add a rider into the station
	 * @param r the rider needs to be added
	 * @return boolean true if the rider is added successfully, otherwise false
	 * 
	 * Running time:O(1)
	 */
	public boolean addRider(Rider r) {
		if(r.direction==1) {
			southBoundRiders.enqueue(r);
			return true;
		}else if(r.direction==0){
			northBoundRiders.enqueue(r);
			return true;
		}
		return false;
	}
	
	/**
	 * This is a method to add a train into the station
	 * @param t the train needs to be added
	 * @return boolean true if the train is added successfully, otherwise false
	 * 
	 * Running time:O(n)
	 */
	public String addTrain(Train t) {
		String record=t.disembarkPassengers();
		if(t.direction==1) {
			southBoundTrains.enqueue(t);
		}else if(t.direction==0) {
			northBoundTrains.enqueue(t);
		}
		record=name+" Disembarking Passengers:\n"+record;
		return record;
	}
	
	/**
	 * This is a method to prepare a southbound train.
	 * @return the train be prepared to go south
	 * 
	 * Running time:O(n)
	 */
	public Train southBoardTrain() {
		if(southBoundTrains==null) {
			return null;
		}
		Train temp=southBoundTrains.front();
		southBoundTrains.dequeue();
		while(temp!=null&&temp.hasSpaceForPassengers()&&southBoundRiders.front()!=null) {
			temp.addPassenger(southBoundRiders.front());
			southBoundRiders.dequeue();
		}
		return temp;
	}
	
	/**
	 * This is a method to prepare a train go to north.
	 * @return the train be prepared to go north
	 * 
	 * Running time:O(n)
	 */
	public Train northBoardTrain() {
		if(northBoundTrains==null) {
			return null;
		}
		Train temp=northBoundTrains.front();
		northBoundTrains.dequeue();
		while(temp!=null&&temp.hasSpaceForPassengers()&&northBoundRiders.front()!=null) {
			temp.addPassenger(northBoundRiders.front());
			northBoundRiders.dequeue();
		}
		return temp;
	}
	
	/**
	 * This is a method to move a train from north to south
	 * 
	 * Running time:O(1)
	 */
	public void moveTrainNorthToSouth() {
		Train temp=northBoundTrains.front();
		if(temp!=null) {
			temp.swapDirection();
			southBoundTrains.enqueue(temp);
			northBoundTrains.dequeue();
		}
	}
	
	/**
	 * This is a method to move a train from south to north
	 * 
	 * Running time:O(1)
	 */
	public void moveTrainSouthToNorth() {
		Train temp=southBoundTrains.front();
		if(temp!=null) {
			temp.swapDirection();
			northBoundTrains.enqueue(temp);
			southBoundTrains.dequeue();
		}
	}
	
	/**
	 * This is a method to return a string containing information about the station
	 * @return a string containing information about the station
	 * 
	 * Running time:O(1)
	 */
	@Override
	public String toString() {
		String result="Station: "+name+"\n"+northBoundTrains.size()+" north-bound trains waiting"+"\n"
						+southBoundTrains.size()+" south-bound trains waiting"+"\n"+northBoundRiders.size()
						+" north-bound passengers waiting"+"\n"+southBoundRiders.size()+" south-bound passengers waiting";
		
		return result;
	}
	
	/**
	 * This is a method to return the station name of the station
	 * @return a string of the station's name 
	 * 
	 * Running time:O(1)
	 */
	public String stationName() {
		return name;
	}
	
	/**
	 * This is a method to check whether two stations are the same 
	 * @return boolean true if the two stations equal, false otherwise
	 * 
	 * Running time:O(1)
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Station) {
			if(((Station) o).stationName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
