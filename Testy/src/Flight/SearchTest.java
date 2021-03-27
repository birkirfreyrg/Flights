package Flight;

import org.junit.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

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
	public void testValidateInt() {
		assertThrows(IllegalArgumentException.class, () -> Search.validateText(123));
	}
	
	@Test
	public void testNullCase() {
		assertNotNull(Search.nullToEmpty("grindavík"));
	}

}
