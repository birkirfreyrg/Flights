package Flight;

public class Plane {
	
	
	//flugvél go vroom
	
	
	int seats;
	int HandicapSupportAvailable;
	String Airline;
	String Model;
	
	public boolean checkHandicapSupport() {
		if (HandicapSupportAvailable <= 0) {
			return false;
		}else {
			return true;
		}
	}

	public static void main(String[] args) {
		
	}
}
