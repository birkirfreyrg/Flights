package Flight;

import java.util.*;

public class Search {
	
	public static boolean validateText(String searchText) {	
		int x = (searchText.length());
		if ( (x==0)||(x>30) )  {
			return false;
		}
		return true;
	}
	
	public static List<Flight> returnMatches(String search) {
		
	}
	
	public static List<Flight> nullToEmpty(String search) {
		/*if(not empty) {
			return result;
		}else {
			return Collections.emptyList();
		}*/
	}
	
	public static void checkReversedDate() {
		
	}
	
	public static void checkSameDate() {
		
	}
	
	public static void main(String[] args) {
		boolean thepriceisright = validateText("virkar þessi strengur?");
		System.out.println(thepriceisright);
		
	}
}
