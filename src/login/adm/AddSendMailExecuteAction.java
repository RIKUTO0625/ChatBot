package login.adm;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.SendMail;
import dao.SendMailDao;
import tool.Action;

public class AddSendMailExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();
		SendMailDao smDao = new SendMailDao();
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得

		//リクエストパラメータ―の取得
		String send_mail = req.getParameter("send_mail");
		Map<String, String> errors = new HashMap<>();// エラーメッセージ

		//未入力時の処理
		if (send_mail == null || send_mail.isEmpty()) {
            errors.put("send_mail", "メールアドレスを入力してください。");
        }

		//エラーがあった時の処理
		if (!errors.isEmpty()) {
            session.setAttribute("errors", errors);
            res.sendRedirect("admin_mail_create.jsp"); // 入力フォームページへ戻る
            return;
        }

		SendMail sendmail = new SendMail();
        sendmail.setMail_address(send_mail); // メールアドレス
        sendmail.setAdmin(admin);     //組織コード
        Boolean success = smDao.createMail(sendmail);

        if (success) {
            res.sendRedirect("admin_mail_create_comp.jsp"); // 登録完了ページへ遷移
        } else {
            errors.put("database", "データベースエラーが発生しました。");
            session.setAttribute("errors", errors);
            res.sendRedirect("admin_mail_create.jsp"); // 入力フォームページへ戻る
        }
	}
}
