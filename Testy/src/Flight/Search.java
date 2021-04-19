package Flight;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class Search {
	
	private List<Flight> searchFlightsResults;
	
	public static boolean validateText(String searchText) {	
		
		int x = (searchText.length());
		if ( (x==0)||(x>30) )  {
			return false;
		}
		return true;
	}
	
	public List<Flight> getAllFlights() throws SQLException, ParseException {
		searchFlightsResults = QueryDB.selectAllFlightsFromDB();
		return searchFlightsResults;
	}
	
	public List<Flight> returnMatches(String destination, String currentloc) throws SQLException, ParseException {
		searchFlightsResults = QueryDB.selectFromDB(destination, currentloc);
		return searchFlightsResults;	
	}
	
	public List<Flight> getMatches() {
		return this.searchFlightsResults;
	}
	
	
	public List<Flight> nullToEmpty(List<Flight> searchResult) {
		boolean empty = searchResult.isEmpty();
		if(!empty) {
			return searchResult;
		}else {
			return Collections.emptyList();
		}
	}
	
	public List<Flight> sortByDate(List<Flight> searchResult) {
		
		return searchResult;	
	}
	
	public List<Flight> sortByName(List<Flight> searchResult) {
		
		return searchResult;	
	}
	
	public void checkReversedDate() {
		
	}
	
	public void checkSameDate() {
		
	}
	
	public static void main(String[] args) throws SQLException, ParseException {
		boolean thepriceisright = validateText("H�navatnas�sla");
		System.out.println(thepriceisright);
		
		List<Flight> fakeList = new ArrayList<Flight>();
		//Flight fakeFlightData = new Flight("Ak", "rvk");
		//fakeList.add(fakeFlightData);
		Search ts = new Search();
		System.out.println(ts.nullToEmpty(fakeList));
		
		//System.out.print(ts.returnMatches("Akureyri", "Reykjavík").toString());
		fakeList = ts.getAllFlights();
		System.out.print(fakeList.toString());
	}
}
