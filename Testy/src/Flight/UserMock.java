package Flight;

public class UserMock {
	
	private String name;
	private String email;
	
	public UserMock(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public void setName(String name) {
        this.name = name;
    }
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
        this.email = email;
    }
	
	public String getEmail() {
		return this.email;
	}

	public static void main(String[] args) {
		UserMock um = new UserMock("Johnny", "Johnny@gmail.com");
		System.out.println(um.getName() + " | " + um.getEmail());
	}

}
