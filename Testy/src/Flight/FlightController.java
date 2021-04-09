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
		for (Flight flight : flights) {
			if (flight.getID() == id) {
				flights.remove(flight);
				break;
			}
		}
	}
}