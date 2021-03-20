package Flight;

import java.sql.SQLException;

public class UserController extends User{
	
	private static User user = new User();
	
	public void createUser(String nm, String em) {
		String[] userinfo = {nm, em};
		try {
			UpdateDB.insertIntoDB(userinfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
