package Flight;
import java.util.*;


public class FlightsMock {
	
	
	// returns 2x flights
	public static  List<Flight> getFlights() {
		Date date = new Date();
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		Flight f1 = new Flight("Reykjavík", "Akureyri", date); 
		Flight f2 = new Flight("Akureyri","Reykjavík", date);
		flightList.add(f1);
		flightList.add(f2);
		return flightList;
		
	}

	public static void main(String[] args) {
		List<Flight> flightList = getFlights();
           for(int i=0;i<flightList.size();i++)  
           {  
            System.out.print(flightList.get(i).getDestination()+", ");
            System.out.print(flightList.get(i).getCurrentLocation()+", "); 
            System.out.println(flightList.get(i).getDepartureTime());
            System.out.println();
           }  
	}
}
