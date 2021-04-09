package Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightController  {
	private List<Flight> flights = new ArrayList<Flight>();
	
	public List<Flight> getFlights() { return flights; } 
	//public void setFlights(Flight[] newflights) { flights = newflights; }
	
	public void createFlight(Flight newflight) {
		flights.add(newflight);
		
	}
	
	public void cancelFlight(int id) {
		// TODO: create function
		/*
		 * for i in flights:
		 * 		if i.id == id:
		 * 			flights.remove(i)
		 * 			break
		 */
	}
}