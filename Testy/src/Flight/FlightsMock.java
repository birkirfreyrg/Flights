package Flight;
import java.util.*;


public class FlightsMock {
	
	// returns 2x flights
	public static  ArrayList<Flight> getFlights() {
		Date date = new Date();
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		  Flight f1 = new Flight("Reykjavík", "Akureyri", date); 
		  Flight f2 = new Flight("Akureyri","Reykjavík", date);
		flightList.add(f1);
		flightList.add(f2);
		return flightList;
		
	}

	public static void main(String[] args) {
		Date date = new Date();
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		  Flight f1 = new Flight("Reykjavík", "Akureyri", date); 
		  Flight f2 = new Flight("Akureyri","Reykjavík", date);
		flightList.add(f1);
		flightList.add(f2);
		for (int i = 0; i < flightList.size(); i++) {
		    System.out.println(flightList.get(i));
		}
	}
}
