package Flight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class FlightsMock {
	
	
	// returns 2x flights
	public static  List<Flight> getFlights() throws ParseException {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		Date d1 = sdformat.parse("2021-03-27");
		Date d2 = sdformat.parse("2021-04-10");
		Flight f1 = new Flight("Reykjavík", "Akureyri", d1); 
		Flight f2 = new Flight("Akureyri","Reykjavík", d2);
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
