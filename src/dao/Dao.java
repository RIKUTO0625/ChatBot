package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Dao {
	/**
	 * データソース:DataSource:クラスフィールド
	 */
	static DataSource ds;
    private static final String URL = "jdbc:postgresql://test-database.cvk6s8aywusg.ap-northeast-1.rds.amazonaws.com:5432/test-database";
    private static final String USER = "Yoshikawa0625";
    private static final String PASSWORD = "test_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
