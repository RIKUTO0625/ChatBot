package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class MemberDeleteAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();
		StaffDao sDao = new StaffDao();

		//リクエストパラメータ―の取得
		String staff_id = req.getParameter("staff_id");
		String staff_pw = req.getParameter("staff_pw");
		Staff staff = null; //職員名

		//DBからデータ取得

			//クリックした職員名のみ表示
		staff = sDao.loginStaff(staff_id,staff_pw);


		//JSPへフォワード 7
		req.getRequestDispatcher("admin_member_delete.jsp").forward(req, res);
	}

}

