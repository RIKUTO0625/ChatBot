package login.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SendMail;
import tool.Action;

public class AddSendMailExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();
		SendMailDao smDao = new SendMailDao();

		//リクエストパラメータ―の取得
		String send_mail = req.getParameter("send_mail");
		SendMail mail = null; //メールアドレス
		Map<String, String> errors = new HashMap<>();// エラーメッセージ

		//DBからデータ取得
		mail = smDao.get(send_mail);

		//新規のメールアドレス
		if(mail == null){
			mail = new SendMail(); //初期化
			mail.setSend_mail(send_mail); //メールアドレス

			//メールアドレス情報の登録
			smDao.save(mail);

		//既存のメールアドレス
		} else {
			errors.put("send_mail","そのメールアドレスは登録済みです");
			return;
		}

		req.getRequestDispatcher("admin_mail_create_comp.jsp").forward(req, res);
	}
}
