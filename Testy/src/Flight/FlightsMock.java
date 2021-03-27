package Flight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class FlightsMock {
	
	
	// returns 2x flights
	public static  List<Flight> getFlights() throws ParseException {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		List<Flight> flightList = new ArrayList<Flight>();
		Date date = new Date();
		Flight f1 = new Flight("Reykjavík", "Akureyri", date); 
		Flight f2 = new Flight("Akureyri","Reykjavík", date);
		flightList.add(f1);
		flightList.add(f2);
		return flightList;
		
	}

	public static void main(String[] args) throws ParseException {
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
