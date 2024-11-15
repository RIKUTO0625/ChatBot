package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Daotest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://mysql-database.cvk6s8aywusg.ap-northeast-1.rds.amazonaws.com:3306/test";
        String username = "admin";
        String password = "test-password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("データベース接続成功!");

            // SQLクエリを準備
            String sql = "CREATE TABLE IF NOT EXISTS staff(id INT AUTO_INCREMENT NOT NULL, name VARCHAR(30) NOT NULL, PRIMARY KEY(id))";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // クエリの実行
            int result = stmt.executeUpdate(); // 変更点: executeUpdate() を使用

            System.out.println("テーブル作成成功! 結果コード: " + result);

         // データを追加
            String insertSql = "INSERT INTO staff (name) VALUES (?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, "Taro");
                insertStmt.executeUpdate();
                insertStmt.setString(1, "Hanako");
                insertStmt.executeUpdate();
                System.out.println("データ追加成功!");
            }

            // データを取得
            String selectSql = "SELECT * FROM staff";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                System.out.println("テーブルデータ:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }



        } catch (Exception e) {
            System.err.println("データベース接続エラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
