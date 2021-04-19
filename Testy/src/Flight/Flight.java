package Flight;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Flight {

	private int id;
	private int cost;
	private int seats;
	private String destination;
	private String currentLocation;
	private Date departureTime;
	private Date arrivalTime;
	
	public int getID( ) { return id; }
	public void setID(int newID ) { id = newID; }
	
	public int getSeats( ) { return seats; }
	public void setSeats(int newSeats ) { seats = newSeats; }
	
	public int getCost() { return cost;}
	public void setCost(int newCost) {cost = newCost;}
	
	public String getDestination( ) { return destination; }
	public void setDestination(String newLoc ) { destination = newLoc; }
	
	public String getCurrentLocation( ) { return currentLocation; }
	public void setCurrentLocation(String newLoc ) { currentLocation = newLoc; }
	
	public Date getDepartureTime( ) { return departureTime; }
	public void setDepartureTime(Date newDate ) { departureTime = newDate; }
	
	public Date getArrivalTime( ) { return arrivalTime; }
	public void setArrivalTime(Date newDate ) { arrivalTime = newDate; }
	
	public String toString() {
		String string = String.format("id: %d, to: %s, from: %s, leaves at %tc, arrives at %tc, price:%d\n", id, destination, currentLocation, departureTime, arrivalTime, cost);
		return string;
	}
	
	public void book(int n) {
		Booking myBooking = new Booking(this, n);
		BookingController BC = new BookingController();
		BC.createBooking(myBooking);
	}
	
	Flight() {
		id = -1;
		cost = 0;
		seats = -1;
		destination = "Þangað";
		currentLocation = "Hérna";
		departureTime = new Date(); // Date() = current date, time
		arrivalTime = new Date();
	}
	
	Flight(int newCost, int newSeats, String newDest, String newLoc, Date depTime, Date arrTime) {
		id = -1;
		cost = newCost;
		seats = newSeats;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = depTime; // Date() = current date, time
		arrivalTime = arrTime;
	}
	
	Flight(String newDest, String newLoc, Date depTime, Date arrTime) {
		id = -1;
		cost = 0;
		seats = -1;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = depTime; // Date() = current date, time
		arrivalTime = arrTime;
	}
	
	Flight(String newDest, String newLoc, Date newDate) {
		id = -1;
		cost = 0;
		seats = -1;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = newDate; // Date() = current date, time
		arrivalTime = newDate;
	}
	
	Flight(String newDest, String newLoc) {
		id = -1;
		cost = 0;
		seats = -1;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = new Date(); // Date() = current date, time
		arrivalTime = new Date();
	}
	
	Flight(int newCost, String newDest, String newLoc, Date depTime, Date arrTime) {
		id = -1;
		cost = newCost;
		seats = -1;
		destination = newDest;
		currentLocation = newLoc;
		departureTime = depTime; // Date() = current date, time
		arrivalTime = arrTime;
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/
	public static void main(String[] args) throws UnsupportedEncodingException {
		Flight flight = new Flight();
		System.out.println(new String(flight.toString().getBytes("UTF-8"),"UTF-8"));
		
	}
}
