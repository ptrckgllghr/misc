import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;


public class ConnectionDemo {
	public static void main(String[] args) throws Exception{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		//Driver class instantiated
		OracleDriver driver = new OracleDriver();
		//Resistering driver with Driver Manager
		DriverManager.registerDriver(driver);
		//Request connection from Driver manager
		Connection conn = DriverManager.getConnection(url, "pjgallagher", "PG123");
		
		System.out.println("Connected successfully...");
		
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(meta.getDatabaseProductName());
		System.out.println(meta.getDatabaseProductVersion());
		System.out.println(meta.getDriverName());
		System.out.println(meta.getDriverVersion());
		
		conn.close();

	}
}
