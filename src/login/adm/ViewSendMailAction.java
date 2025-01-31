package login.adm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.SendMail;
import dao.SendMailDao;
import tool.Action;

public class ViewSendMailAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();
		SendMailDao smDao = new SendMailDao();
		List<SendMail> sendmail = null; // メールアドレス
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得
		//リクエストパラメータ―の取得 2
		//なし
		//DBからデータ取得 3

		//ビジネスロジック 4

		sendmail = smDao.viewMail(admin.getAd_cd());

		System.out.println(sendmail);
		System.out.println(sendmail.size());


		//確認用
		req.setAttribute("ad_name", admin.getAd_name());
		req.setAttribute("mailList", sendmail);

		//JSPへフォワード 7
		req.getRequestDispatcher("admin_mail_list.jsp").forward(req, res);
	}

}
