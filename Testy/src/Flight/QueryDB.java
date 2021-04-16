package Flight;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Date;

public class QueryDB {
	public static List<Flight> selectAllFlightsFromDB() throws SQLException, ParseException {
		 Connection con = null;
	     List<Flight> flightList = new ArrayList<Flight>();
	     try {
	     Class.forName("org.sqlite.JDBC");
	     con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
	     Statement st2 = con.createStatement();
	     String scanning = "SELECT * FROM Flight";
	     ResultSet rs = st2.executeQuery(scanning);
	     if (!rs.isBeforeFirst() ) {    
	         System.out.println("No flights available"); 
	     } 
	     while(rs.next()) {
	         String departureTime = rs.getString("departureTime");
	         String arrivalTime = rs.getString("arrivalTime");
	         Date DT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(departureTime);
	         Date AT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(arrivalTime);

	         Flight f = new Flight(rs.getString("destination"),rs.getString("currentLoc"), DT, AT);
	         f.setID(rs.getInt("id"));
	         flightList.add(f);
	     }
	     rs.close();
	       
	        
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
	     return flightList;	        
	}
	
	public static List<Flight> selectFromDB(String destination, String currentLoc) throws SQLException, ParseException {
        Connection con = null;
        List<Flight> flightList = new ArrayList<Flight>();
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st2 = con.createStatement();
        String scanning = "SELECT * FROM Flight WHERE destination = '"+ destination +"' AND currentLoc = '"+ currentLoc + "'";
        ResultSet rs = st2.executeQuery(scanning);
        if (!rs.isBeforeFirst() ) {    
            System.out.println("Could not find flight"); 
        } 
        while(rs.next()) {
            String departureTime = rs.getString("departureTime");
            String arrivalTime = rs.getString("arrivalTime");
            Date DT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(departureTime);
            Date AT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(arrivalTime);

            Flight f = new Flight(rs.getString("destination"),rs.getString("currentLoc"), DT, AT);
            f.setID(rs.getInt("id"));
            flightList.add(f);
        }
        rs.close();
        
        
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
        return flightList;
        
    }
	
	public static List<Flight> selectFromDB(String destination, String currentLoc, Date dateFrom, Date dateTo) throws SQLException, ParseException {
        Connection con = null;
        List<Flight> flightList = new ArrayList<Flight>();
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st2 = con.createStatement();
        String scanning = "SELECT * FROM Flight WHERE destination = '"+ destination +"' AND currentLoc = '"+ currentLoc + "'";
        ResultSet rs = st2.executeQuery(scanning);
        if (!rs.isBeforeFirst() ) {    
            System.out.println("Could not find flight"); 
        } 
        while(rs.next()) {
            String departureTime = rs.getString("departureTime");
            String arrivalTime = rs.getString("arrivalTime");
            Date DT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(departureTime);
            Date AT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(arrivalTime);

            if(!DT.before(dateFrom) && !DT.after(dateTo)) {
            	Flight f = new Flight(rs.getString("destination"),rs.getString("currentLoc"), DT, AT);
                f.setID(rs.getInt("id"));
                flightList.add(f);
            }
        }
        rs.close();
        
        
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
        return flightList;
        
    }

public static void main(String[] args) throws SQLException, ParseException{
	
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, -4);
    calendar.add(Calendar.HOUR_OF_DAY, -17);
    Date dateTo = new Date();
    dateTo = calendar.getTime();
    calendar.setTime(date);
    calendar.add(calendar.DAY_OF_MONTH, -6);
    Date dateFrom = new Date();
    dateFrom = calendar.getTime();
    
    System.out.println(dateFrom);
    System.out.println(dateTo);
	
	
	List<Flight> flightList = new ArrayList<Flight>();
	flightList = selectFromDB("Reykjavik", "Akureyri", dateFrom, dateTo);
	System.out.print(flightList);
	
}

}
