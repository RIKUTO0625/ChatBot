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
		Staff staff = null;

		//リクエストパラメータ―の取得
		String staff_id = req.getParameter("staff_id");
		String staff_pw = req.getParameter("staff_pw");

		//DBからデータ取得

		//クリックした職員名のみ表示
		staff = sDao.loginStaff(staff_id,staff_pw);
		System.out.println(staff);


		//セッションに"staff"という変数名で値はstaff変数の中身
		session.removeAttribute("staff"); //値のリセット
		session.setAttribute("staff", staff);

		//レスポンス値をセット
		req.setAttribute("staff_name", staff.getStaff_name());

		//JSPへフォワード 7
		req.getRequestDispatcher("../staff/staff_delete.jsp").forward(req, res);
	}

}

