package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Daotest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://test-database.cvk6s8aywusg.ap-northeast-1.rds.amazonaws.com:5432/*";
        String username = "postgres";
        String password = "test-password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("データベース接続成功!");
        } catch (Exception e) {
            System.err.println("データベース接続エラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
