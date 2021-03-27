package Flight;

import java.util.Date;

public class Flight {

	private Plane plane;
	private String destination;
	private String currentLocation;
	private Date departureTime;
	private Date arrivalTime;
	
	public Plane getPlane( ) { return plane; }
	public void setPlane(Plane newPlane ) { plane = newPlane; }
	
	public String getDestination( ) { return destination; }
	public void setDestination(String newLoc ) { destination = newLoc; }
	
	public String getCurrentLocation( ) { return currentLocation; }
	public void setCurrentLocation(String newLoc ) { currentLocation = newLoc; }
	
	public Date getDepartureTime( ) { return departureTime; }
	public void setDepartureTime(Date newDate ) { departureTime = newDate; }
	
	public Date getArrivalTime( ) { return arrivalTime; }
	public void setArrivalTime(Date newDate ) { arrivalTime = newDate; }
	
	Flight() {
		plane = new Plane();
		destination = "Þangað";
		currentLocation = "Hérna";
		departureTime = new Date(); // Date() = current date, time
		arrivalTime = new Date();
	}
	
	Flight(Plane newPlane, String newDest, String newLoc, Date depTime, Date arrTime) {
		plane = newPlane;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = depTime; // Date() = current date, time
		arrivalTime = arrTime;
	}
	
	Flight(String newDest, String newLoc, Date depTime, Date arrTime) {
		plane = new Plane();
		destination = newDest;
		currentLocation = newLoc;
		departureTime = depTime; // Date() = current date, time
		arrivalTime = arrTime;
	}
	
	Flight(String newDest, String newLoc, Date newDate) {
		plane = new Plane();
		destination = newDest;
		currentLocation = newLoc;
		departureTime = newDate; // Date() = current date, time
		arrivalTime = newDate;
	}
	
	Flight(String newDest, String newLoc) {
		plane = new Plane();
		destination = newDest;
		currentLocation = newLoc;
		departureTime = new Date(); // Date() = current date, time
		arrivalTime = new Date();
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/

}
