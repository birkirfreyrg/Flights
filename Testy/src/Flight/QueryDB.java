package Flight;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class QueryDB {
	public static List<Flight> selectFromDB(String destination, String currentLoc) throws SQLException, ParseException {
        Connection con = null;
        List<Flight> flightList = new ArrayList<Flight>();
        Date AT = null;Date DT = null;
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
            DT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(departureTime);
            AT = (Date) new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(arrivalTime);

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

public static void main(String[] args) throws SQLException, ParseException{
	
	List<Flight> flightList = new ArrayList<Flight>();
	flightList = selectFromDB("Reykjavik", "Akureyri");
	Flight f = flightList.get(0);
	System.out.print(f.toString());
}

}
