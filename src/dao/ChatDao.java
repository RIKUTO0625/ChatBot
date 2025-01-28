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

    	Connection conn = null;
    	PreparedStatement stmt = null;
	    ResultSet rs = null;

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

	    try {

		    conn = getConnection();
		    stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	        // プレースホルダーに値を設定
	        stmt.setString(1, staff.getStaff_id());
	        stmt.setString(2, day);

	        // クエリを実行
	        rs = stmt.executeQuery();

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

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("Error while retrieving chat data.", e);
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
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}


	    return list;
	}

	public List<List<Integer>> getHis(Staff staff, int year) throws Exception {

	    // 質問ごとの回答数を格納するリスト
	    List<List<Integer>> sumList = new ArrayList<>();


    	Connection conn = null;
    	PreparedStatement stmt = null;
	    ResultSet rs = null;

	    // 8つの質問を初期化（質問数が固定の場合）
	    for (int i = 0; i < 8; i++) {
	        List<Integer> queList = new ArrayList<>();
	        // 5つの回答の初期値を0に設定
	        for (int j = 0; j < 5; j++) {
	            queList.add(0);
	        }
	        sumList.add(queList);
	    }

	    // SQLクエリ
	    String sql =
	        "SELECT " +
	            "q.que_no, a.ans_no, COUNT(c.chat_no) AS total_answers " +
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
	            "AND EXTRACT(YEAR FROM c.date) = ? " +
	        "WHERE s.staff_id = ? " +
	        "GROUP BY q.que_no, a.ans_no " +
	        "ORDER BY q.que_no, a.ans_no";

	    try {

	        conn = getConnection();
	        stmt = conn.prepareStatement(sql);
	        // プレースホルダーに値を設定
	        stmt.setInt(1, year);  // 年
	        stmt.setString(2, staff.getStaff_id());  // スタッフID

	        // クエリを実行
	        rs = stmt.executeQuery();

            while (rs.next()) {
                int queNo = rs.getInt("que_no");
                int ansNo = rs.getInt("ans_no");
                int totalAnswers = rs.getInt("total_answers");

                // 質問番号と回答番号に対応するリスト要素を更新
                if (queNo >= 1 && queNo <= 8 && ansNo >= 1 && ansNo <= 5) {
                    sumList.get(queNo - 1).set(ansNo - 1, totalAnswers);
                }
            }


	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("Error while retrieving chat data.", e);
	    }finally {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return sumList;
	}

	public List<List<Integer>> getHisMonth(Staff staff, int year, int month) throws Exception {

	    // 質問ごとの回答数を格納するリスト
	    List<List<Integer>> sumList = new ArrayList<>();


    	Connection conn = null;
    	PreparedStatement stmt = null;
	    ResultSet rs = null;

	    // 8つの質問を初期化（質問数が固定の場合）
	    for (int i = 0; i < 8; i++) {
	        List<Integer> queList = new ArrayList<>();
	        // 5つの回答の初期値を0に設定
	        for (int j = 0; j < 5; j++) {
	            queList.add(0);
	        }
	        sumList.add(queList);
	    }

	    // SQLクエリ
	    String sql =
	        "SELECT " +
	            "q.que_no, a.ans_no, COUNT(c.chat_no) AS total_answers " +
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
	        "WHERE s.staff_id = ? " +
	        	"AND AND EXTRACT(YEAR FROM c.date) = ? " +
	        	"AND EXTRACT(MONTH FROM c.date) = ? " +
	        "GROUP BY q.que_no, a.ans_no " +
	        "ORDER BY q.que_no, a.ans_no";

	    try {

	        conn = getConnection();
	        stmt = conn.prepareStatement(sql);
	        // プレースホルダーに値を設定
	        stmt.setString(1, staff.getStaff_id());  // スタッフID
	        stmt.setInt(2, year);  // 年
	        stmt.setInt(2, month);  // 月
	        // クエリを実行
	        rs = stmt.executeQuery();

            while (rs.next()) {
                int queNo = rs.getInt("que_no");
                int ansNo = rs.getInt("ans_no");
                int totalAnswers = rs.getInt("total_answers");

                // 質問番号と回答番号に対応するリスト要素を更新
                if (queNo >= 1 && queNo <= 8 && ansNo >= 1 && ansNo <= 5) {
                    sumList.get(queNo - 1).set(ansNo - 1, totalAnswers);
                }
            }


	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new Exception("Error while retrieving chat data.", e);
	    }finally {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return sumList;
	}


	// 質問別、履歴取得
	public boolean setChat(Staff staff, List<List<Integer>> chat_list) throws Exception {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    String sql = "INSERT INTO chat (que_no, ans_no, date, ad_cd, staff_id) VALUES (?, ?, now()::date, ?, ?);";

	    conn = getConnection();
	    stmt = conn.prepareStatement(sql);

	    // 実行件数
	    int count = 0;

	    try {
	        // chat_list の各ペアをループで処理
	        for (List<Integer> pair : chat_list) {
	            if (pair.size() < 2) {
	                // データが不正な場合はスキップ（必要に応じて例外を投げる処理も可能）
	                continue;
	            }

	            stmt.setInt(1, pair.get(0)); // que_no
	            stmt.setInt(2, pair.get(1)); // ans_no
	            stmt.setString(3, staff.getAdmin().getAd_cd()); // ad_cd
	            stmt.setString(4, staff.getStaff_id()); // staff_id

	            // プリペアードステートメントを実行
	            count += stmt.executeUpdate();
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        // リソースのクローズ処理
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	    }

	    return count > 0; // 実行件数が1件以上の場合は true を返す
	}


    public List<String> getQueTextList() throws Exception {
        // 返却用のリストを初期化
        List<String> textList = new ArrayList<>();

        // SQL文
        String sql = "SELECT que_text FROM question";

        // DB接続
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        // SQLを実行
        ResultSet rs = stmt.executeQuery();

        // 結果をリストに追加
        while (rs.next()) {
            textList.add(rs.getString("que_text"));
        }

        // リソースをクローズ
        rs.close();
        stmt.close();
        conn.close();

        // リストを返却
        return textList;
    }


    public List<String> getAnsTextList() throws Exception {
        // 返却用のリストを初期化
        List<String> textList = new ArrayList<>();

        // SQL文
        String sql = "SELECT ans_text FROM answer";

        // DB接続
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        // SQLを実行
        ResultSet rs = stmt.executeQuery();

        // 結果をリストに追加
        while (rs.next()) {
            textList.add(rs.getString("ans_text"));
        }

        // リソースをクローズ
        rs.close();
        stmt.close();
        conn.close();

        // リストを返却
        return textList;
    }


}