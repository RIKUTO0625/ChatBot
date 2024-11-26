package login.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class DeleteStaffExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session=req.getSession();

		//ビジネスロジック
		session.removeAttribute("staff_id");

		//JSPへフォワード
		req.getRequestDispatcher("staff_delete_comp.jsp").forward(req, res);
	}

}
