package Flight;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class UpdateDB {
    public static int insertIntoDB(String[] userInfo) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY, name varchar(30), email varchar(30))";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO User(name, email) SELECT '" + userInfo[0] +"' , '" + userInfo[1] + "' WHERE NOT EXISTS(SELECT 1 FROM User WHERE name = '" + userInfo[0] +"' and email = '" + userInfo[1] + "')";
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }
        //int rows = st.executeUpdate(sqlInsertingValues);
        /*
        if (rows > 0) {
            System.out.println("A row created");
        }
        
        String checking = "SELECT * FROM User";
        ResultSet rs = st.executeQuery(checking);
        while(rs.next())
        {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " | " + name + " | " + email);
        }
        rs.close();
        */
        
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
    
    public static int insertIntoFlightDB(String currentLoc, String destination, Date departureTime, Date arrivalTime) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS Flight(id INTEGER PRIMARY KEY, currentLoc varchar(30), destination varchar(30), departureTime varchar(30), arrivalTime varchar(30))";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO Flight(currentLoc, destination, departureTime, arrivalTime) Values( '"+ currentLoc +"', '"+ destination +"', '"+departureTime+"', '"+arrivalTime+"')";
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }
        //int rows = st.executeUpdate(sqlInsertingValues);
        /*
        if (rows > 0) {
            System.out.println("A row created");
        }
        
        String checking = "SELECT * FROM User";
        ResultSet rs = st.executeQuery(checking);
        while(rs.next())
        {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " | " + name + " | " + email);
        }
        rs.close();
        */
        
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
    
    public static void deleteFromDB(String[]  wantDeleted, int identifier) throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlCheckingID = "SELECT * FROM User";
        
        String actualName = ""; String actualEmail = "";

        ResultSet rsID = st.executeQuery(sqlCheckingID);
        if (!rsID.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rsID.next()) {
        	int id = rsID.getInt("id");
        	if (id == identifier) {
        		actualName = rsID.getString("name");
                actualEmail = rsID.getString("email");
                if(actualName.equals(wantDeleted[0]) && actualEmail.equals(wantDeleted[1])) {
                	String sqlDeleting = "DELETE FROM User WHERE name = '"+ wantDeleted[0]+"' AND email = '"+ wantDeleted[1]+"'";
                    st.executeUpdate(sqlDeleting);
                    System.out.println(wantDeleted[0] + " was deleted.");
                }
        	}else {
            	System.out.println("can't delete what doesn't exist");
            }
        }

        String checking = "SELECT * FROM User";
        ResultSet rs = st.executeQuery(checking);
        while(rs.next())
        {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " | " + name + " | " + email);
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
    }
    
    public static void updateDB(int identifier, String oldName, String oldEmail, String newName, String newEmail) throws SQLException{
    	Connection con = null;
    	try {
    		Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
            Statement st = con.createStatement();
            String actualName = ""; String actualEmail = "";
            String sqlCheckingID = "SELECT * FROM User";
            ResultSet rsID = st.executeQuery(sqlCheckingID);
            if (!rsID.isBeforeFirst() ) {    
                System.out.println("No data"); 
            } 
            while(rsID.next()) {
            	int id = rsID.getInt("id");
            	if (id == identifier) {
            		actualName = rsID.getString("name");
                    actualEmail = rsID.getString("email");
                    if(actualName.equals(oldName) && actualEmail.equals(oldEmail)) {
                    	String sqlDeleting = "UPDATE User SET name = '" + newName + "', email = '"+newEmail+"' WHERE id = "+ identifier;
                        st.executeUpdate(sqlDeleting);
                        System.out.println(oldName +" was changed to "+newName+ " and the "+oldEmail+" was changed to "+newEmail);
                    }
            	}
            	else {
            		System.out.println("User doesnt exist");
            	}
            }
            String checking = "SELECT * FROM User";
            ResultSet rs = st.executeQuery(checking);
            while(rs.next())
            {
            	int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println(id + " | " + name + " | " + email);
            }

            // comment
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
    }
    

    
    public static void main(String[] args) throws SQLException{
        
        // insertIntoFlightDB(String currentLoc, String destination, Date departureTime, Date arrivalTime)
    	Date date = new Date();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, 1);
	    Date dateArrival = new Date();
	    dateArrival = calendar.getTime();
    	insertIntoFlightDB("Reykjavik", "Akureyri", date, dateArrival);

        
    }
    
}