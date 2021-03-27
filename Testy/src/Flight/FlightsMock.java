package Flight;
import java.util.*;


public class FlightsMock {
	
	
	// returns 2x flights
	public static  List<Flight> getFlights() {
		List<Flight> flightList = new ArrayList<Flight>();
		Date date = new Date();
		int hours = date.getHours();
		System.out.println(hours);
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    Date dateArrival = new Date();
	    dateArrival = calendar.getTime();
		Flight f1 = new Flight("Reykjavík", "Akureyri", date, dateArrival); 
		Flight f2 = new Flight("Akureyri","Reykjavík", date, dateArrival);
		flightList.add(f1);
		flightList.add(f2);
		return flightList;
		
	}

	public static void main(String[] args) {
		List<Flight> flightList = getFlights();
           for(int i=0;i<flightList.size();i++)  
           {
        	System.out.print(flightList.get(i).getCurrentLocation()+" til "); 
            System.out.println(flightList.get(i).getDestination());
            System.out.print("Departure Time: ");
            System.out.println(flightList.get(i).getDepartureTime());
            System.out.print("Arrival Time: ");
            System.out.println(flightList.get(i).getArrivalTime());
            System.out.println("-------------------------------------------------");
           }  
	}
}
