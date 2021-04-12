package Flight;


public class Booking {
	private int id;
	private Flight flight;
	private String passenger;
	private Boolean handicap;
	
	public int getID( ) { return id; }
	public void setID(int newID ) { id = newID; }
	
	public Flight getFlight( ) { return flight; }
	public void setFlight(Flight newFlight ) { flight = newFlight; }
	
	public String getpassenger( ) { return passenger; }
	public void setpassenger(String newpassenger ) { passenger= newpassenger; }
	
	public Boolean checkHandicap( ) { return handicap; }
	public void setHandicap(Boolean handicapp ) { handicap = handicapp; }
	
	public String toString() {
		String string = String.format("Booking id: %d\nFlight Info: %sPassenger: %s\nRequires handicap support: %b\n", id, flight, passenger, handicap);
		return string;
	}
	
	Booking() {
		id = -1;
		flight = new Flight();
		passenger = "john doe";
		handicap = false;
	}
	
	Booking(Flight newFlight, String newpassenger, Boolean newHandicap){
		flight = newFlight;
		passenger = newpassenger;
		newHandicap = handicap;
	}
	Booking(Flight newFlight, String newpassenger){
		flight = newFlight;
		passenger = newpassenger;
		handicap = false;
				
	}
	public static void main(String args[]) {
		Booking book = new Booking();
		
	}
}
