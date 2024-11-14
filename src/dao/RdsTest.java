package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RdsTest {
    public static void main(String[] args) {
        // Daoクラスのインスタンス作成
        Dao dao = new Dao();

        try (Connection conn = dao.getConnection()) {
            System.out.println("データベース接続成功");

            // SQLクエリを準備
            String sql = "SELECT * FROM test-database"; // your_table_nameをRDSのテーブル名に変更
            PreparedStatement stmt = conn.prepareStatement(sql);

            // クエリの実行
            ResultSet rs = stmt.executeQuery();

            // 結果の表示
            while (rs.next()) {
                // テーブルのカラム名を指定
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (Exception e) {
            // 例外処理
            System.err.println("データベース接続エラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
