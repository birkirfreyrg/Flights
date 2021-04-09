package Flight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDB {
	public static List<Flight> selectFromDB(String currentLoc, String destination) throws SQLException {
        Connection con = null;
        List<Flight> flightList = new ArrayList<Flight>();
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st2 = con.createStatement();
        String scanning = "SELECT * FROM Flight WHERE currentLoc = '"+ currentLoc +"' AND destination = '"+ destination + "'";
        ResultSet rs = st2.executeQuery(scanning);
        if (!rs.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rs.next()) {
        	Flight f = new Flight(rs.getString("currentLoc"),rs.getString("destination"));
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

public static void main(String[] args) throws SQLException{
	
	List<Flight> flightList = new ArrayList<Flight>();
	flightList = selectFromDB("Reykjavik", "Akureyri");
	
}

}
