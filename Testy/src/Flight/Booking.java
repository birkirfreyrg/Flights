package Flight;


public class Booking {
	private int id;
	private Flight flight;
	private int cost;
	private Passenger passenger;
	private Boolean handicap;
	
	public int getID( ) { return id; }
	public void setID(int newID ) { id = newID; }
	
	public int getCost( ) { return cost; }
	public void setCost(int newCost ) { cost = newCost; }
	
	public Flight getFlight( ) { return flight; }
	public void setFlight(Flight newFlight ) { flight = newFlight; }
	
	public Passenger getpassenger( ) { return passenger; }
	public void setpassenger(Passenger newpassenger ) { passenger= newpassenger; }
	
	public Boolean checkHandicap( ) { return handicap; }
	public void setHandicap(Boolean handicapp ) { handicap = handicapp; }
	
	public String toString() {
		String string = String.format("Booking id: %d\nFlight Info: %sPassenger: %sRequires handicap support: %b\n", id, flight, passenger, handicap);
		return string;
	}
	
	Booking() {
		id = -1;
		flight = new Flight();
		passenger = new Passenger();
		handicap = false;
	}
	
	Booking(Flight newFlight, Passenger newpassenger, Boolean newHandicap){
		id = -1;
		flight = newFlight;
		passenger = newpassenger;
		newHandicap = handicap;
	}
	Booking(Flight newFlight, Passenger newpassenger){
		id = -1;
		flight = newFlight;
		passenger = newpassenger;
		handicap = false;
				
	}
	
	Booking(Flight newFlight, int newCost, Passenger newpassenger){
		id = -1;
		flight = newFlight;
		cost = newCost;
		passenger = newpassenger;
		handicap = false;
				
	}
	public static void main(String args[]) {
		Booking book = new Booking();
		
	}
}
