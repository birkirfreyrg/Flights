package Flight;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightController  {
	private List<Flight> flights = new ArrayList<Flight>();
	
	public List<Flight> getFlights() { return flights; } 
	//public void setFlights(Flight[] newflights) { flights = newflights; }
	
	public List<Flight> getAllFlights() throws SQLException, ParseException {
		flights = QueryDB.selectAllFlightsFromDB();
		return flights;
	}
	
	public void createFlight(Flight newflight) {
		flights.add(newflight);
	}
	
	public boolean availableFlight(Flight flight, int passengers) {
		int seatsAvailable = flight.getSeats();
		boolean available = false;
		if(seatsAvailable >= passengers) {
			available = true;
		}else {
			available = false;
		}
		
		return available;
	}
	
	public Flight getFlightById(int id) {
		for (Flight flight : flights) {
			if (flight.getID() == id) {
				return flight;
			}
		}
		System.out.format("No flight with id number: %d\n", id);
		return null;
	}
	
	public void cancelFlight(int id) {
		for (Flight flight : flights) {
			if (flight.getID() == id) {
				flights.remove(flight);
				break;
			}
		}
	}
	public static void main(String[] args) throws SQLException, ParseException {
		FlightController fc = new FlightController();
		Search sc = new Search();
		
		// get all available flights from DB and select one of them from id.
		System.out.println(fc.getAllFlights());
		Flight flight = fc.getFlightById(2);
		System.out.println(flight);
		
		// return flights searched with destination and current location.
		System.out.println(sc.returnMatches("Reykjavik", "Akureyri"));
	}
}