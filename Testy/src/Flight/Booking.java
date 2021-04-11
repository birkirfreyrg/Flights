package Flight;


public class Booking {
	private int id;
	private Flight flight;
	private String passanger;
	private Boolean handicap;
	
	public int getID( ) { return id; }
	public void setID(int newID ) { id = newID; }
	
	public Flight getFlight( ) { return flight; }
	public void setFlight(Flight newFlight ) { flight = newFlight; }
	
	public String getPassanger( ) { return passanger; }
	public void setPassanger(String newPassanger ) { passanger= newPassanger; }
	
	public Boolean checkHandicap( ) { return handicap; }
	public void setHandicap(Boolean handicapp ) { handicap = handicapp; }
	
	Booking() {
		id = -1;
		flight = new Flight();
		passanger = "john doe";
		handicap = false;
	}
	
	Booking(Flight newFlight, String newPassanger, Boolean newHandicap){
		flight = newFlight;
		passanger = newPassanger;
		newHandicap = handicap;
	}
	Booking(Flight newFlight, String newPassanger){
		flight = newFlight;
		passanger = newPassanger;
		handicap = false;
				
	}
}
