package Flight;
import java.sql.*;

public class QueryDB {
	public static List<Flight> selectFromDB(String currentLoc, String destination) throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st2 = con.createStatement();
        String scanning = "SELECT * FROM User";
        ResultSet rs = st2.executeQuery(scanning);
        if (!rs.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rs.next()) {
        	
        }
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
    }
}
