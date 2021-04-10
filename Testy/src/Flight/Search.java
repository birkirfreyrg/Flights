package Flight;

import java.sql.SQLException;
import java.util.*;

public class Search {
	
	public static boolean validateText(String searchText) {	
		
		int x = (searchText.length());
		if ( (x==0)||(x>30) )  {
			return false;
		}
		return true;
	}
	
	public List<Flight> returnMatches(String destination, String currentloc) throws SQLException {
		return QueryDB.selectFromDB(destination, currentloc);	
	}
	
	public List<Flight> nullToEmpty(List<Flight> searchResult) {
		boolean empty = searchResult.isEmpty();
		if(!empty) {
			return searchResult;
		}else {
			return Collections.emptyList();
		}
	}
	
	public static void checkReversedDate() {
		
	}
	
	public static void checkSameDate() {
		
	}
	
	public static void main(String[] args) throws SQLException {
		boolean thepriceisright = validateText("Húnavatnasýsla");
		System.out.println(thepriceisright);
		
		List<Flight> fakeList = new ArrayList<Flight>();
		//Flight fakeFlightData = new Flight("Ak", "rvk");
		//fakeList.add(fakeFlightData);
		Search ts = new Search();
		System.out.println(ts.nullToEmpty(fakeList));
		
		System.out.print(ts.returnMatches("Olafsvik", "Reykjavik").toString());
	}
}
