package Flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;

class UserControllerTest {

	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserExisting() {
		UserController myUC = new UserController();
		User myUser = myUC.createUser("name","email@email.org");
		myUC.deleteUser(myUser);
	}
	
	@Test
	public void testDeleteUserNotExisting() {
		UserController myUC = new UserController();
		User myUser = myUC.createUser("name","email@email.org");
		myUC.deleteUser(myUser);
		myUC.deleteUser(myUser);
	}

}
