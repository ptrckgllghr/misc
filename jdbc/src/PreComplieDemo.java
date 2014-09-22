import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PreComplieDemo {
	
	public static void main(String[] args) throws SQLException {
		//? are known as place-holders
		String sql = "insert into person values(?,?,?)";
		
		Connection conn = null;
		conn = JdbcUtility.newConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		//Index of column statrs with 1 in JDBC
		stmt.setString(1, args[0]);
		stmt.setInt(2, Integer.parseInt(args[1]));
		stmt.setString(3, args[2]);
		stmt.executeUpdate();
		System.out.println("Record inserted...");
	}
}
