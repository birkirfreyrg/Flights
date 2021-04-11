package Flight;

public class BookingController {
	
	private Booking booking;
	
	public void bookFlight(Flight flight, String Passenger, boolean handicap) {
		booking.setFlight(flight);
		booking.setpassenger(Passenger);
		booking.setHandicap(handicap);
	}

	public static void main(String[] args) {
		BookingController bc = new BookingController();
		bc.bookFlight(, null, false);
	}

}
