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
		// create user -> assert
		String name = "name";
		String email = "email@email.org";
		UserController myUC = new UserController();
		User myUser = myUC.createUser(name, email);
		assertEquals(name, myUser.getName());
		assertEquals(email, myUser.getEmail());
	}

	@Test
	public void testUpdateUser() {
		String oldName = "name";
		String oldEmail = "email@email.org";
		UserController myUC = new UserController();
		User myUser = myUC.createUser(oldName, oldEmail);
		String newName = "nameNew";
		String newEmail = "emailNew@email.org";
		myUC.updateUser(myUser, newName, newEmail);
	}

	@Test
	public void testDeleteUserExisting() {
		// create -> delete user, vantar assert
		UserController myUC = new UserController();
		User myUser = myUC.createUser("name","email@email.org");
		myUC.deleteUser(myUser);
	}
	
	@Test
	public void testDeleteUserNotExisting() {
		// create -> delete user -> delete user (aftur), vantar assert/catch
		UserController myUC = new UserController();
		User myUser = myUC.createUser("name","email@email.org");
		myUC.deleteUser(myUser);
		myUC.deleteUser(myUser);
	}

}
