package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Chat;
import bean.Staff;

public class ChatDao extends Dao {

	public List<Chat> getChat(Staff staff, String day) throws Exception {

	    // リストを初期化
	    List<Chat> list = new ArrayList<>();
	    Chat chat = null;

	    // SQLクエリ
	    String sql = "SELECT " +
	        "c.chat_no, " +
	        "c.date, " +
	        "c.que_no, " +
	        "c.ans_no, " +
	        "q.que_text AS question, " +
	        "a.ans_text AS answer, " +
	        "c.staff_id, " +
	        "c.ad_cd " +
	        "FROM " +
	        "chat c " +
	        "INNER JOIN question q ON c.que_no = q.que_no " +
	        "INNER JOIN answer a ON c.ans_no = a.ans_no " +
	        "INNER JOIN admin ad ON c.ad_cd = ad.ad_cd " +
	        "INNER JOIN staff s ON c.staff_id = s.staff_id " +
	        "WHERE " +
	        "c.staff_id = ? " +  // プレースホルダーを使用
	        "AND c.date = ?";

	    try (
	        Connection conn = getConnection();
	        PreparedStatement stmt = conn.prepareStatement(sql)
	    ) {
	        // プレースホルダーに値を設定
	        stmt.setString(1, staff.getStaff_id());
	        stmt.setString(2, day);

	        // クエリを実行
	        try (ResultSet rs = stmt.executeQuery()) {
	            // 結果を処理
	            while (rs.next()) {
	                chat = new Chat();

	                // 結果セットから値を取得し、Chatオブジェクトに設定
	                chat.setChat_no(rs.getInt("chat_no"));
	                chat.setDate(rs.getDate("date"));
	                chat.setQue_no(rs.getInt("que_no"));
	                chat.setAns_no(rs.getInt("ans_no"));
	                chat.setQue_text(rs.getString("question"));
	                chat.setAns_text(rs.getString("answer"));
	                chat.setStaff_id(rs.getString("staff_id"));
	                chat.setAd_cd(rs.getString("ad_cd"));

	                // リストに追加
	                list.add(chat);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("Error while retrieving chat data.", e);
	    }

	    return list;
	}

	public List<List<Integer>> getHis(Staff staff, int year) throws Exception {

	    // リストを初期化
	    List<List<Integer>> sum_list = new ArrayList<>();

	    // SQLクエリ
	    String sql =
	        "SELECT " +
	            "s.staff_id, " +
	            "q.que_no, " +
	            "a.ans_no, " +
	            "COUNT(c.chat_no) AS total_answers, " +
	            "COALESCE(EXTRACT(YEAR FROM c.date), ?) AS year " +
	        "FROM " +
	            "staff s " +
	        "CROSS JOIN " +
	            "question q " +
	        "CROSS JOIN " +
	            "answer a " +
	        "LEFT JOIN " +
	            "chat c ON s.staff_id = c.staff_id " +
	                "AND q.que_no = c.que_no " +
	                "AND a.ans_no = c.ans_no " +
	                "AND (EXTRACT(YEAR FROM c.date) = ? OR c.date IS NULL) " +
	        "WHERE " +
	            "s.staff_id = ? " +
	        "GROUP BY " +
	            "s.staff_id, q.que_no, a.ans_no, COALESCE(EXTRACT(YEAR FROM c.date), ?) " +
	        "ORDER BY " +
	            "s.staff_id, q.que_no, a.ans_no";

	    try (
	        Connection conn = getConnection();
	        PreparedStatement stmt = conn.prepareStatement(sql)
	    ) {
	        // プレースホルダーに値を設定
	        stmt.setInt(1, year);  // 年
	        stmt.setInt(2, year);  // 年
	        stmt.setString(3, staff.getStaff_id());  // 職員ID
	        stmt.setInt(4, year);  // 年

	        // クエリを実行
	        try (ResultSet rs = stmt.executeQuery()) {

	            // 質問の数（例: 5件）
	            for (int i = 1; i <= 8; i++) {
	                // 質問ごとに回答数のリストを作成
	                List<Integer> que_list = new ArrayList<>();

	                // 回答ID（例: 8件）
	                for (int j = 1; j <= 5; j++) {
	                    // 結果を処理
	                    while (rs.next()) {
	                        int que_no = rs.getInt("que_no");
	                        int ans_no = rs.getInt("ans_no");
	                        int total_answers = rs.getInt("total_answers");

	                        // 質問IDと回答IDが一致する場合のみ、リストに追加
	                        if (que_no == i && ans_no == j) {
	                            que_list.add(total_answers); // 回答数をリストに追加
	                        }
	                    }

	                    // 結果が無ければ0を追加
	                    if (que_list.size() < j) {
	                        que_list.add(0); // データがなければ0を追加
	                    }

	                    // 結果をリストに追加
	                }

	                // 質問ごとの結果をリストに追加
	                sum_list.add(que_list);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("Error while retrieving chat data.", e);
	    }

	    return sum_list;
	}



	// 質問別、履歴取得
    public boolean setChat(Staff staff, int answer_no , int question_no) throws Exception{

    	String sql = "INSERT INTO chat (que_no, ans_no, date, ad_cd, staff_id)VALUES (?, ?, now()::date, ?, ?);";


        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);

		// 実行件数
		int count = 0;

		try {

		    stmt.setInt(1, question_no);
		    stmt.setInt(2, answer_no);
		    stmt.setString(3, staff.getAdmin().getAd_cd());
		    stmt.setString(4, staff.getStaff_id());

			//プリペアードステートメントを実行
			count = stmt.executeUpdate ();

		}catch(Exception e) {
				throw e;
		}finally {
			// プリペアードステートメントを閉じる
			if (stmt != null) {
				try {
					stmt. close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (conn != null) {
				try {
					conn.close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			//実行件数が1件以上ある場合
			return true;
		}else{
		    //実行件数が0件の場合
		    return false;
		}


    }

    public String getAnsText(int answer_no) throws Exception{

    	String text = "";

        String sql = "SELECT ans_text FROM answer where ans_no = ? ";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, answer_no);

	    ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

    	    text = rs.getString("ans_text");

        }


        return text;
    }

    public String getQueText(int question_no) throws Exception{

    	String text = "";

        String sql = "SELECT que_text FROM question where que_no = ? ";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, question_no);

	    ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

    	    text = rs.getString("que_text");

        }

        return text;

    }

}