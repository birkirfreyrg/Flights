package Flight;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class SearchTest {

	/*
	@Before
	public void setUp() {
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void returnMatches() {
		List<Flight> actualValue = Search.returnMatches("from=Reykjavík;to=Akureyri");
		List<Flight> expectedValue = FlightsMock.getFlights("");
		assertEquals(expectedValue, actualValue, "search failed ");
		
	}
	
	
	@Test
	public void testValidateInt() {
		assertThrows(IllegalArgumentException.class, () -> Search.validateText(123));
	}
	
	@Test
	public void testValidateCorrectString() {
		assertEquals(Search.validateText("from=Reykjavík;to=Akureyri"), true);
	}
	
	@Test
	public void testNullCase() {
		assertNotNull(Search.nullToEmpty("grindavík"));
	}
	
	@Test
	public void testSearchNull() {
		assertThrows(IllegalArgumentException.class, () -> Search.returnMatches());
	}
	
	@Test
	public void testSameDate(Flight flight) {
		Date date = new Date();
		Date dateArrival = new Date();
		date = flight.getDepartureTime();
		dateArrival = flight.getArrivalTime();
		assertEquals(date, dateArrival);
	}
	
	@Test
	public void testReverseDate(Flight flight) {
		assertThrows(IllegalArgumentException.class, () -> Search.checkReversedDate());
	}
	
	

}
