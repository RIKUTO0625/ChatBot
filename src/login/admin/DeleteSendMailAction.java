package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SendMail;
import tool.Action;

public class DeleteSendMailAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();

		//リクエストパラメータ―の取得
		String send_mail = req.getParameter("send_mail");
		SendMail mail = null; //メールアドレス

		//DBからデータ取得


		//JSPへフォワード
		req.getRequestDispatcher("admin_mail_delete.jsp").forward(req, res);
	}

}

