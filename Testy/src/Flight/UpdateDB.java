package Flight;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class UpdateDB {
    
    public static int insertIntoFlightDB(String destination, String currentLoc, Date departureTime, Date arrivalTime, int cost) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS FlightTable(id INTEGER PRIMARY KEY, destination varchar(30), currentLoc varchar(30), departureTime varchar(30), arrivalTime varchar(30), cost INTEGER, seat INTEGER)";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO FlightTable(destination, currentLoc, departureTime, arrivalTime, cost, seat) Values( '"+ destination +"', '"+ currentLoc +"', '"+departureTime+"', '"+arrivalTime+"', "+cost+", 50)";
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }  
        return return_id;
    }
    
    public static int insertIntoBookingDB(Booking booking) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS Bookings(id INTEGER PRIMARY KEY, flight varchar(30), cost varchar(30))";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO Bookings(flight, cost) Values( '"+ booking.getFlight() +"', '"+ booking.getCost() +"')";
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }       
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }  
        return return_id;
    }
    
    public static void deleteFromFlightDB(int identifier) throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlCheckingID = "SELECT * FROM Flight";

        ResultSet rsID = st.executeQuery(sqlCheckingID);
        if (!rsID.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rsID.next()) {
        	int id = rsID.getInt("id");
        	if (id == identifier) {
                	String sqlDeleting = "DELETE FROM FlightTable WHERE id = '"+identifier+"'";
                    st.executeUpdate(sqlDeleting);
                    System.out.println(identifier + " was deleted.");
                }
        	else{
            	System.out.println("can't delete what doesn't exist");
            }
        }


        rsID.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    
    public static void deleteFlightDB() throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlDeleting = "DELETE FROM FlightTable";
        String sqlVacuum = "VACUUM";
        st.executeUpdate(sqlDeleting);
        st.executeUpdate(sqlVacuum);
        System.out.println("FlightsDB was deleted.");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    
    public static void updateSeatDB(int identifier, int seatChange) throws SQLException{
    	Connection con = null;
    	try {
    		Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
            Statement st = con.createStatement();
            String sqlCheckingID = "SELECT * FROM FlightTable";
            ResultSet rsID = st.executeQuery(sqlCheckingID);
            if (!rsID.isBeforeFirst() ) {    
                System.out.println("No data"); 
            } 
            while(rsID.next()) {
            	int id = rsID.getInt("id");
            	if (id == identifier) {
                    String sqlDeleting = "UPDATE FlightTable SET seat = seat + "+seatChange+" WHERE id = "+ identifier;
                    st.executeUpdate(sqlDeleting);
            	}
            }
            // comment
            rsID.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    

    
    public static void main(String[] args) throws SQLException{
        
        // insertIntoFlightDB(String currentLoc, String destination, Date departureTime, Date arrivalTime)
    	
    	Date date = new Date();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, 7);
	    Date dateArrival = new Date();
	    dateArrival = calendar.getTime();
	    calendar.setTime(date);
	    calendar.add(calendar.DAY_OF_MONTH, 3);
	    Date dateInbetween = new Date();
	    dateInbetween = calendar.getTime();
	    Flight flight = new Flight("Akureyri", "Reykjavik", date, dateArrival);
    	//insertIntoFlightDB("Akureyri", "Reykjavik", date, dateArrival); 	
    	
    	Booking booking = new Booking(flight, 10000);
        insertIntoBookingDB(booking);
       
	    System.out.println(date);
	    System.out.println(dateInbetween);
	    System.out.println(dateArrival);
	    if(!dateInbetween.before(date) && !dateInbetween.after(dateArrival)) {
	    	System.out.println("Date is inside the date searched");
	    }else {
	    	System.out.println("Date is not inside the date searched");
	    }
	    updateSeatDB(28, -3);
    }
    
}