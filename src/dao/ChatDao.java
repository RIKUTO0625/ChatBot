package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Chat;
import bean.Staff;

public class ChatDao extends Dao {

	// 質問別、履歴取得
    public List<Chat> getChat(Staff staff, int answer_no , int question_no) throws Exception{

		// リストを初期化
	    List<Chat> list = new ArrayList<>();

    	Chat chat = null;

        String sql = "SELECT * FROM chat where staff_id = ? and ans_no = ? and que_no = ?";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, staff.getStaff_id());
	    stmt.setInt(2, answer_no);
	    stmt.setInt(3, question_no);

	    ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

        	int chat_no  = rs.getInt("chat_no");
        	int ans_no  = rs.getInt("ans_no");
        	int que_no  = rs.getInt("que_no");
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

	        list.add(chat);

        }

        return list;
    }

}