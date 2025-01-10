package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SendMail;
import dao.SendMailDao;
import tool.Action;

public class DeleteSendMailAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//削除予定のメールアドレスを表示させる
		HttpSession session = req.getSession();
		SendMailDao smDao = new SendMailDao();
		SendMail sendmail = null;

		//次回はここから
		String mail_id = req.getParameter("mail_id");

		//↓クリックしたメールアドレスのみ表示させてほしい
//		sendmail = smDao.loginMail(mail_id);

		//JSPへフォワード
		req.getRequestDispatcher("admin_mail_delete.jsp").forward(req, res);
	}

}

