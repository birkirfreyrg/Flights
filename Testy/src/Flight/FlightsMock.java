package Flight;
import java.util.*;

public class FlightsMock {
	
	// returns 5x flights
	public static  ArrayList<Flight> getFlights() {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		flightList.add();
		flightList.add();
		flightList.add();
		return flightList;	
	}

	public static void main(String[] args) {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		  Flight f1 = new Flight("Reykjavík", "Akureyri", );    
		flightList.add();
		for (int i = 0; i < flightList.size(); i++) {
		    System.out.println(flightList.get(i));
		}
		LocalDate myObj = LocalDate.now(); // Create a date object
	    System.out.println(myObj); // Display the current date
	  }
	}

}
