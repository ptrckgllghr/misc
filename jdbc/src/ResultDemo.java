import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class ResultDemo {
	
	public static void main(String[] args) throws SQLException {
		String sql = "select * from person";
		Connection conn = null;
		
		try {
			conn = JdbcUtility.newConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println(meta.getColumnLabel(1) + "\t" + meta.getColumnLabel(2) + "\t" + meta.getColumnLabel(3));
			
			while(rs.next())
				System.out.println(rs.getString(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
