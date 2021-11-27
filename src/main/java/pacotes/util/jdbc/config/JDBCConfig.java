package main.java.pacotes.util.jdbc.config;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author Tiago M
 */
public class JDBCConfig {
	private static String url;
	private static String user;
	private static String password;
	private static Connection connection;

	public JDBCConfig() {
		JDBCProperties jdbc = new JDBCProperties();
		url = jdbc.get("url");
		user = jdbc.get("username");
		password = jdbc.get("password");
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, JDBCConfig.user, JDBCConfig.password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}