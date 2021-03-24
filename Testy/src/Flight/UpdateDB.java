package Flight;

import java.sql.*;

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
    
    public static void deleteFromDB(String[]  wantDeleted, int identifier) throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlCheckingID = "SELECT * FROM User";
        ResultSet rsID = st.executeQuery(sqlCheckingID);
        int actual = 0; String actualName = ""; String actualEmail = "";
        while(rsID.next()) {
        	int id = rsID.getInt("id");
        	if (id == identifier) {
        		String name = rsID.getString("name");
                String email = rsID.getString("email");
                if(name == wantDeleted[0] || email == wantDeleted[1]) {
                	actual = id;
                }
        	}
        }
        if(actual == identifier) {
        	String sqlDeleting = "DELETE FROM User WHERE name = '"+ wantDeleted[0]+"' AND email = '"+ wantDeleted[1]+"'";
            st.executeUpdate(sqlDeleting);
        }else {
        	System.out.println("can't delete what doesn't exist");
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
    
    public static void main(String[] args) throws SQLException{
        String[] userInfo1 = new String[2];
        userInfo1[0] = "Indiana Jones";
        userInfo1[1] = "jones123@gmail.com";
        String[] userInfo2 = new String[2];
        userInfo2[0] = "jonny cash";
        userInfo2[1] = "jonnyjon@gmail.com";
        insertIntoDB(userInfo1);
        deleteFromDB(userInfo1, 1);


        
    }
    
}