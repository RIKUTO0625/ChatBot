package login.adm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class MemberAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ローカル変数の宣言
		HttpSession session = req.getSession();
		StaffDao sDao = new StaffDao();
		List<Staff> staff = null; // 職員
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得

		//ビジネスロジック

		staff = sDao.viewStaff(admin.getAd_cd());

//	    String admin_cd = req.getParameter("ad_cd"); // admin_cdをリクエストから取得
//
//	    // Staffオブジェクトを生成し、ad_cdを設定
//	    Staff staffData = new Staff();
//	    staffData.setAd_cd(admin_cd); // admin_cdをStaffオブジェクトに設定
//
//	    // DBからデータ取得
//	    staff = sDao.viewStaff(staffData); // Staffオブジェクトを渡す

		System.out.println(staff);

	    // 取得した職員データをリクエスト属性に設定
		req.setAttribute("ad_name", admin.getAd_name());
	    req.setAttribute("staffList", staff);

	    // JSPへフォワード
	    req.getRequestDispatcher("admin_member.jsp").forward(req, res);
	}
}

