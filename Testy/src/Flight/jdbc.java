package Flight;
import java.sql.*;

public class jdbc {
	
	public static Connection connect() {
		Connection con = null;
		try {
		Class.forName("org.sqlite.JDBC");
		DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
		System.out.println("connected");
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e+"");
		}
		return con;
	}
	public static void main(String[] args) {
		jdbc.connect();
	}
	
}