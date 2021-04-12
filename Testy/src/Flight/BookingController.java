package Flight;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookingController {
	
	private List<Booking> bookings = new ArrayList<Booking>();
	
	
	public void createBooking(Booking newBooking) {
		bookings.add(newBooking);
	}
	
	public Booking getBookingById(int id) {
		for (Booking booking : bookings) {
			if (booking.getID() == id) {
				return booking;
			}
		}
		System.out.format("No Booking with id number: %d\n", id);
		return null;
	}
	

	public static void main(String[] args) throws SQLException, ParseException {
		BookingController bc = new BookingController();
		/*Date date = new Date();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, 1);
	    Date dateArrival = new Date();
	    dateArrival = calendar.getTime();
		Flight flight = new Flight("Akureyri", "Reykjavik", date, dateArrival);
		*/
		
		FlightController fc = new FlightController();
		List<Flight> allFlights = new ArrayList<Flight>();
		allFlights = fc.getAllFlights();
		Flight flight = fc.getFlightById(2);
		System.out.println(flight);
		Booking bookingTest = new Booking(flight, "John Doe", false);
		bc.createBooking(bookingTest);
		System.out.println(bc.getBookingById(0).toString());
		//System.out.prtinln(gc.getBooking )
	}

}
