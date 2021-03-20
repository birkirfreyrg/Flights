package Flight;

import java.sql.*;

public class UpdateDB {
    public static void insertIntoDB(String[] userInfo) throws SQLException {
        Connection con = null;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY, name varchar(30), email varchar(30))";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO User(name, email) VALUES('" + userInfo[0] +"' , '" + userInfo[1] + "' )";
        int rows = st.executeUpdate(sqlInsertingValues);
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
    
    public static void deleteFromDB(String[]  wantDeleted) throws SQLException {
        Connection con = null;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlDeleting = "DELETE FROM User WHERE name = '"+ wantDeleted[0]+"' ";
        st.executeUpdate(sqlDeleting);
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
        insertIntoDB(userInfo2);
        deleteFromDB(userInfo1);
        
    }
    
}