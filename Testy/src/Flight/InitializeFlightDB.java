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
	
	public void initializeFlightDB() throws SQLException {
		UpdateDB.deletFlightDB();
		InitializeFlightDB ifdb = new InitializeFlightDB();
		ifdb.createFlightInDB("Ólafsvík", "Reykjavík", "Fri Apr 02 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 02 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Mon Apr 05 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Mon Apr 05 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Wed Apr 07 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Wed Apr 07 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Fri Apr 09 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 09 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Mon Apr 12 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Mon Apr 12 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Wed Apr 14 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Wed Apr 14 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Fri Apr 16 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 16 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Mon Apr 19 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Mon Apr 19 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Wed Apr 21 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Wed Apr 21 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Fri Apr 23 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 23 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Mon Apr 26 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Mon Apr 26 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Wed Apr 28 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Wed Apr 28 22:00:00 GMT 2021");
		ifdb.createFlightInDB("Olafsvik", "Reykjavik", "Fri Apr 30 20:00:00 GMT 2021");
		ifdb.createFlightInDB("Reykjavík", "Ólafsvík", "Fri Apr 30 22:00:00 GMT 2021");
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
		InitializeFlightDB ifdb = new InitializeFlightDB();
		ifdb.initializeFlightDB();
	}

}
