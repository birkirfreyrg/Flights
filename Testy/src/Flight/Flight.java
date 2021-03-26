package Flight;

import java.util.Date;

public class Flight {

	private Plane plane;
	private String destination;
	private String currentLocation;
	private Date departureTime;
	
	public Plane getPlane( ) { return plane; }
	public void setPlane(Plane newPlane ) { plane = newPlane; }
	
	public String getDestination( ) { return destination; }
	public void setDestination(String newLoc ) { destination = newLoc; }
	
	public String getCurrentLocation( ) { return currentLocation; }
	public void setCurrentLocation(String newLoc ) { currentLocation = newLoc; }
	
	public Date getDepartureTime( ) { return departureTime; }
	public void setDepartureTime(Date newDate ) { departureTime = newDate; }
	
	Flight() {
		plane = new Plane();
		destination = "Þangað";
		currentLocation = "Hérna";
		departureTime = new Date(); // Date() = current date, time
	}
	
	Flight(Plane newPlane, String newDest, String newLoc, Date newDate) {
		plane = newPlane;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = newDate; // Date() = current date, time
	}
	
	Flight(String newDest, String newLoc, Date newDate) {
		plane = new Plane();
		destination = newDest;
		currentLocation = newLoc;
		departureTime = newDate; // Date() = current date, time
	}
	
	Flight(String newDest, String newLoc) {
		plane = new Plane();
		destination = newDest;
		currentLocation = newLoc;
		departureTime = new Date(); // Date() = current date, time
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/

}
