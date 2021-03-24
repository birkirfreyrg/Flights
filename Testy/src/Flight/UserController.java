package Flight;

import java.sql.SQLException;

public class UserController extends User{
	
	private static User user = new User();
	
	public static UserMock createUser(String nm, String em) {
		String[] userinfo = {nm, em};
		int id = -1;
		try {
			id = UpdateDB.insertIntoDB(userinfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMock myUser = new UserMock(nm, em, id);
		System.out.println(nm+" | "+ em + " | " + id);
		return myUser;
	}
	
	public void updateUser() {
		
	}
	
	public void deleteUser() {
		
	}
	

	public static void main(String[] args) {
		createUser("nameTest", "emailTest"); 
	}

}
