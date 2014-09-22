import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;


public class JdbcUtility {

	public static Connection newConnection() throws SQLException{
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, "pjgallagher", "PG123");
		return conn;
		
	}
}
