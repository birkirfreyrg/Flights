package Flight;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
		List<Flight> actualValue = Search.returnMatches("Reykjav�k", "Akureyri");
		List<Flight> expectedValue = FlightsMock.getFlights();
		assertEquals(expectedValue, actualValue, "search failed ");
		
	}
	
	
	@Test
	public void testValidateInt() {
		assertThrows(IllegalArgumentException.class, () -> Search.validateText(123));
	}
	
	@Test
	public void testNullCase() {
		assertNotNull(Search.nullToEmpty("grindav�k"));
	}
	
	@Test
	public void testSearchNull() {
		assertThrows(IllegalArgumentException.class, () -> Search.returnMatches());
	}
	
	

}
