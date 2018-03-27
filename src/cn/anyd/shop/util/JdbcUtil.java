package cn.anyd.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {

	// static {
	// try{
	// String url = "jdbc:mysql://localhost:3306/shop";

	// Connection connection = DriverManager.getConnection(url,"root","root");
	// System.out.println(connection);
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new RuntimeException(e);
	// }
	// }
	public static void close(Connection connection, PreparedStatement pre) {
		
		close(connection, pre, null);

	}

	public static void close(Connection connection, PreparedStatement pre, ResultSet rs) {

		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			try {
				if (pre != null && !pre.isClosed()) {
					pre.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (connection != null && !connection.isClosed()) {
						connection.close();
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

			}

		}
	}

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/shop";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
