import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TransactionDemo {

	public static void main(String[] args) {
		
		String sql1 = "insert into person values ('George', 25, 'Atlanta')";
		String sql2 = "update person set age=21 where name ='kelly'";
		String sql3 = "delete from person where nam='Ken'"; //intentional mistake
		Connection conn = null;
		
		try {
			conn = JdbcUtility.newConnection();
			Statement stmt = conn.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			conn.setAutoCommit(false);//Setting auto commit off
			stmt.executeBatch();	  //Executing multiple queries together
			conn.commit();			  //Make changes permanent to DB if there's no exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
