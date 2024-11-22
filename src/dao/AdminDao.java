package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class AdminDao extends Dao {

	// 職員ログイン時
    public Admin loginAdmin(String ad_cd, String pass) throws Exception{

    	Admin admin = null;

    	//school_cdによってJOIN SCHOOLさせて、SCHOOL_nameがゲットできるように
        String sql = "SELECT * FROM admin where ad_cd = ? and ad_pw = ?";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, ad_cd);
	    stmt.setString(2, pass);

	    ResultSet rs = stmt.executeQuery();

        if (rs.next()) { // 認証成功の場合（該当アカウントがあった場合）

        	String cd = rs.getString("ad_cd");
            String name = rs.getString("ad_name");
            String pw = rs.getString("ad_pw");

	        admin = new Admin();

	        admin.setAd_cd(cd);
	        admin.setAd_name(name);
	        admin.setAd_pw(pw);
        }

        return admin;
    }
}