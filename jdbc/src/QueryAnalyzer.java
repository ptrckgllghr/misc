import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class QueryAnalyzer {

	public static void executeQuery(String sql) {
		Connection conn = null;

		try {
			conn = JdbcUtility.newConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			int numOfColumns = meta.getColumnCount();

			for (int i = 0; i < numOfColumns; i++)
			{
				System.out
						.print(padRight(meta.getColumnName(i + 1), 15) + "\t");
			}
				
			System.out.println("");

			while (rs.next()) {
				for (int i = 0; i < numOfColumns; i++)
					System.out.print(padRight(rs.getString(i + 1), 15) + "\t");
				System.out.println("");	
			}
			System.out.println("----------------------------------------");
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * pads a String s with empty spaces so it is n characters long
	 * 
	 * @param s
	 *            - string to format
	 * @param n
	 *            - size of full string
	 * @return
	 */
	private static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

}
