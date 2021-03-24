package Flight;

public class UserMock {
	
	private String name;
	private String email;
	private int id;
	
	public UserMock(String name, String email, int id) {
		this.name = name;
		this.email = email;
		this.id = id;
	}
	
	public void setName(String name) {
        this.name = name;
    }
	
	public int getId() {
		return this.id;
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
		UserMock um = new UserMock("Johnny", "Johnny@gmail.com", 1);
		System.out.println(um.getName() + " | " + um.getEmail());
	}

}
