package Flight;

import java.sql.*;

public class UpdateDB {
	public static void insertIntoDB(String[] userInfo) throws SQLException {
		Connection con = null;
		try {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
		System.out.println("connected");
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e+"");
		}
		Statement st = con.createStatement();
		String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY, name varchar(30), email varchar(30))";
		st.executeUpdate(sqlCreatingTable);
		System.out.println("table created");
		String sqlInsertingValues = "INSERT INTO User(name, email) VALUES('" + userInfo[0] + "' , '" + userInfo[1] + "')";
		int rows = st.executeUpdate(sqlInsertingValues);
        if (rows > 0) {
            System.out.println("A row created");
        }
		
        String sql = "select * from User";
        
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
        	int id = result.getInt("id");
            String name = result.getString("name");
            String email = result.getString("email");

            System.out.println(id + " | " + name + " | " + email);
            
		
        }
		try
	      {
	        if(con != null)
	          con.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	}
	
	public static void main(String[] args) throws SQLException{
		String[] userInfo = new String[2];
		userInfo[0] = "Indiana Jones";
		userInfo[1] = "jones123@gmail.com";
		insertIntoDB(userInfo);
	}
	
}
