package Flight;

public class UserController extends User{
	
	private static User user = new User();
	
	public void createUser() {
		
	}
	
	public void updateUser() {
		
	}
	
	public void deleteUser() {
		
	}
	

	public static void main(String[] args) {
		user.setName("foo bar");
		System.out.println(user.getName());
	}

}
