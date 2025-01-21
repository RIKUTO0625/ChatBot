package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Chat;
import bean.Staff;

public class ChatDao extends Dao {

	// 質問別、履歴取得
    public List<Chat> getChat(Staff staff, String day) throws Exception{

		// リストを初期化
	    List<Chat> list = new ArrayList<>();

    	Chat chat = null;

        String sql = "SELECT * FROM chat where staff_id = ? and date = ?";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, staff.getStaff_id());
	    stmt.setString(2, day);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) { // if -> while に修正
	        int chat_no = rs.getInt("chat_no");
	        int ans_no = rs.getInt("ans_no");
	        int que_no = rs.getInt("que_no");
	        String staff_id = rs.getString("staff_id");
	        String ad_cd = rs.getString("ad_cd");
	        Date date = rs.getDate("date");

	        chat = new Chat();

	        chat.setChat_no(chat_no);
	        chat.setAns_no(ans_no);
	        chat.setQue_no(que_no);
	        chat.setStaff_id(staff_id);
	        chat.setAd_cd(ad_cd);
	        chat.setDate(date);

	        list.add(chat); // 複数件のデータを追加
	    }

        return list;
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