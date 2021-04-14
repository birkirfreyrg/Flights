package Flight;


public class Booking {
	private int BookingID;
	private Flight flight;
	private int cost; 
	private Passenger passenger;
	
	public int getID( ) { return BookingID; }
	public void setID(int newID ) { BookingID = newID; }
	
	public int getCost( ) { return cost; }
	public void setCost(int newCost ) { cost = newCost; }
	
	public Flight getFlight( ) { return flight; }
	public void setFlight(Flight newFlight ) { flight = newFlight; }
	
	public Passenger getpassenger( ) { return passenger; }
	public void setpassenger(Passenger newpassenger ) { passenger= newpassenger; }
	
	public String toString() {
		String string = String.format("Booking id: %d\nFlight Info: %sPassenger: %sRequires handicap support: %b\n", BookingID, flight, passenger);
		return string;
	}
	
	Booking() {
		BookingID = -1;
		flight = new Flight();
		passenger = new Passenger();
	}
	
	Booking(Flight newFlight){
		BookingID = -1;
		flight = newFlight;
	}
	
	Booking(Flight newFlight, Passenger newpassenger){
		BookingID = -1;
		flight = newFlight;
		passenger = newpassenger;		
	}
	
	Booking(Flight newFlight, int newCost, Passenger newpassenger){
		BookingID = -1;
		flight = newFlight;
		cost = newCost;
		passenger = newpassenger;
				
	}
	public static void main(String args[]) {
		Booking book = new Booking();
		
	}
}
