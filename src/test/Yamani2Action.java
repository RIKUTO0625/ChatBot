package test;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Staff;
import dao.ChatDao;
import tool.Action;

public class Yamani2Action extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

	    HttpSession session = req.getSession();
	    ChatDao chatDao = new ChatDao();
	    Map<String, String> errors = new HashMap<>();

	    // Adminオブジェクトを作成
	    Admin admin = new Admin();
	    admin.setAd_cd("000000");

	    // スタッフオブジェクトを作成
	    Staff staff = new Staff();
	    staff.setAdmin(admin);
	    staff.setStaff_id("staff001");
	    staff.setAd_cd(admin.getAd_cd());

	    boolean bool = chatDao.setChat(staff, 1, 1);

	    System.out.println(bool);

	    req.setAttribute("bool", bool);

	    res.sendRedirect("yamani.jsp");
	}
}
