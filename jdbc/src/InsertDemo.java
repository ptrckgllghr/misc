import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		String sql = "insert into person values ('Jackie Wilson', 22, 'Toronto')";
		Connection conn = null;

		try {
			conn = JdbcUtility.newConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Record Inserted...");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Record Insertion failed...");
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
