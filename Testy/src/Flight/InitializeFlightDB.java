package Flight;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InitializeFlightDB {
	
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	 

	
	public void createFlightInDB(String dest, String currLoc, String departureDate) throws SQLException {
		Date date = parseDate(departureDate);
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, 1);
	    Date dateArrival = new Date();
	    dateArrival = calendar.getTime();
		UpdateDB.insertIntoFlightDB(dest, currLoc, date, dateArrival); 	
	}

	public static void main(String[] args) throws SQLException {
		UpdateDB.deletFlightDB();
		InitializeFlightDB ifdb = new InitializeFlightDB();
		ifdb.createFlightInDB("Ólafsvík", "Reykjavík", "Fri Apr 16 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 16 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Fri Apr 17 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 17 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Fri Apr 18 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 18 22:00:00 GMT 2021");
	}

}
