package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://mysql-database.cvk6s8aywusg.ap-northeast-1.rds.amazonaws.com:3306/test";
        String username = "admin";
        String password = "test-password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("データベース接続成功!");

            // adminテーブル作成SQL
            String createAdminTableSql = "CREATE TABLE IF NOT EXISTS admin ("
                    + "ad_cd CHAR(6) NOT NULL, "
                    + "ad_pw VARCHAR(20) NOT NULL, "
                    + "ad_name VARCHAR(20) NOT NULL, "
                    + "PRIMARY KEY (ad_cd))";
            try (PreparedStatement stmt = conn.prepareStatement(createAdminTableSql)) {
                int result = stmt.executeUpdate();
                System.out.println("adminテーブル作成成功! 結果コード: " + result);
            }

            // staffテーブル作成SQL (admin_cd を外部キーとして追加)
            String createStaffTableSql = "CREATE TABLE IF NOT EXISTS staff ("
                    + "staff_id CHAR(8) NOT NULL, "
                    + "staff_name VARCHAR(20) NOT NULL, "
                    + "staff_age INT NOT NULL, "
                    + "staff_belong VARCHAR(20), "
                    + "staff_pw VARCHAR(20), "
                    + "admin_cd CHAR(6), "  // admin_cd列を追加
                    + "PRIMARY KEY (staff_id), "
                    + "FOREIGN KEY (admin_cd) REFERENCES admin (ad_cd))";
            try (PreparedStatement stmt = conn.prepareStatement(createStaffTableSql)) {
                int result = stmt.executeUpdate();
                System.out.println("staffテーブル作成成功! 結果コード: " + result);
            }

//            // adminテーブルにデータ追加
//            String insertAdminSql = "INSERT INTO admin (ad_cd, ad_pw, ad_name) VALUES (?, ?, ?)";
//            try (PreparedStatement insertStmt = conn.prepareStatement(insertAdminSql)) {
//                insertStmt.setString(1, "000000");
//                insertStmt.setString(2, "test");
//                insertStmt.setString(3, "Kanazawa");
//                insertStmt.executeUpdate();
//                System.out.println("adminデータ追加成功!");
//            }
//
//            // staffテーブルにデータ追加
//            String insertStaffSql = "INSERT INTO staff (staff_id, staff_pw, staff_name, staff_belong, staff_age, admin_cd) "
//                    + "VALUES (?, ?, ?, ?, ?, ?)";
//            try (PreparedStatement insertStmt = conn.prepareStatement(insertStaffSql)) {
//                insertStmt.setString(1, "staff000");
//                insertStmt.setString(2, "test");
//                insertStmt.setString(3, "TAKASHI");
//                insertStmt.setString(4, "秘書課");
//                insertStmt.setInt(5, 100);
//                insertStmt.setString(6, "000000"); // admin_cd は adminテーブルの ad_cd に対応
//                insertStmt.executeUpdate();
//                System.out.println("staffデータ追加成功!");
//            }

            // staffテーブルのデータを選択
            String selectSql = "SELECT * FROM staff";
            System.out.println("現在のテーブルデータ:");

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("staff_id");
                    String name = rs.getString("staff_name");
                    Integer age = rs.getInt("staff_age");
                    System.out.println("ID: " + id + ", Name: " + name + ",age" + age);
                }
            }

        } catch (Exception e) {
            System.err.println("データベース接続エラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
