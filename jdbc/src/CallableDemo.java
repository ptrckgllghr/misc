import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class CallableDemo {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		
		try {
			conn = JdbcUtility.newConnection();
			CallableStatement stmt = conn.prepareCall("{call getAge(?,?)}");
			stmt.setString(1, "Patric");
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.execute();
			System.out.println("Age: " + stmt.getInt(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
