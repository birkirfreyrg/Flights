package Flight;
import java.sql.*;

public class Initialize {
	
	
	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:sqlite:Flight.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
	}
}
