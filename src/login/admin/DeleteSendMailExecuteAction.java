package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class DeleteSendMailExecuteAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();

		//ビジネスロジック
		session.removeAttribute("send_mail");

		//JSPへフォワード 7
		req.getRequestDispatcher("admin_mail_delete_comp.jsp").forward(req, res);
	}

}

