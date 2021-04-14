package Flight;

import java.util.ArrayList;
import java.util.List;

public class PassengerController {
	
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	public List<Passenger> getPassengers() { return passengers; } 
	
	
	
	public void createPassenger(Passenger newPassenger) {
		passengers.add(newPassenger);
	}
	
	public Passenger getPassengerById(int id) {
		for (Passenger passenger : passengers) {
			if (passenger.getId() == id) {
				return passenger;
			}
		}
		System.out.format("No passenger with id number: %d\n", id);
		return null;
	}
	
	public void deletePassenger(int id) {
		for (Passenger passenger : passengers) {
			if (passenger.getId() == id) {
				passengers.remove(passenger);
				break;
			}
		}
	}

	public static void main(String[] args) {
		PassengerController pc = new PassengerController();
		
		Passenger fakePassenger = new Passenger("Paul", 21);
		Passenger fakePassengerTwo = new Passenger("Jack", 53);
		pc.createPassenger(fakePassenger);
		pc.createPassenger(fakePassengerTwo);
		System.out.println(pc.getPassengers());
	}

}
