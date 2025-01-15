package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SendMail;
import tool.Action;

public class DeleteSendMailAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//削除予定のメールアドレスを表示させる
		HttpSession session = req.getSession();
		SendMail sendmail = new SendMail();


		String mail_id = req.getParameter("mail_id");
		String mail_address = req.getParameter("mail_address");
		String ad_cd = req.getParameter("ad_cd");


		sendmail.setMail_id(mail_id);
		sendmail.setAd_cd(ad_cd);
		sendmail.setMail_address(mail_address);

		session.setAttribute("sendmail", sendmail);

		//↓クリックしたメールアドレスのみ表示させてほしい
//		sendmail = smDao.loginMail(mail_id);

		//JSPへフォワード
		req.getRequestDispatcher("admin_mail_delete.jsp").forward(req, res);
	}

}

