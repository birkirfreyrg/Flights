package Flight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDB {
	public static List<Flight> selectFromDB(String destination, String currentLoc) throws SQLException {
        Connection con = null;
        List<Flight> flightList = new ArrayList<Flight>();
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st2 = con.createStatement();
        String scanning = "SELECT * FROM Flight WHERE destination = '"+ destination +"' AND currentLoc = '"+ currentLoc + "'";
        ResultSet rs = st2.executeQuery(scanning);
        if (!rs.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rs.next()) {
        	Flight f = new Flight(rs.getString("destination"),rs.getString("currentLoc"));
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
	flightList = selectFromDB("Akureyri", "Reykjavik");
	Flight f = flightList.get(0);
	System.out.print(f.toString());
}

}
