package Flight;

public class User {
	private String name;
	private String email;
	//private BookingCatalog myBookings;
	//private Passanger[] myPassangers; 
	
	
	/*public void createPassenger(String name, int age) {
		name = this.name;
	}*/
	
	/*public list getMyBookings() {
		...
	}*/
	
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
		User u = new User();
		
		u.name = "Foo";
		u.email = "Bar@bar.is";
		System.out.println(u.name);
		System.out.println(u.email);

	}

}
