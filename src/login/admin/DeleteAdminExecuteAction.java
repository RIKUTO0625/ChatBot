package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class DeleteAdminExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言
		HttpSession session=req.getSession();

		//ビジネスロジック
		session.removeAttribute("staff_cd");

		//JSPへフォワード
		req.getRequestDispatcher("admin_delete_comp.jsp").forward(req, res);
	}

}
