package login.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SendMail;
import dao.SendMailDao;
import tool.Action;

public class DeleteSendMailExecuteAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		SendMailDao smDao = new SendMailDao();
		HttpSession session = req.getSession();

		//どちらかによる違いはありますか？
//		session.removeAttribute("mail_id");

		//リクエストパラメータ―の取得
		String mail_id = req.getParameter("mail_id");
		String send_mail = req.getParameter("send_mail");
		String ad_cd = req.getParameter("ad_cd");
		Map<String, String> errors = new HashMap<>();// エラーメッセージ

		SendMail sendmail = new SendMail();
		sendmail.setSend_mail(mail_id);   //メールアドレス番号
        sendmail.setSend_mail(send_mail); // メールアドレス
        sendmail.setSend_mail(ad_cd);     //組織コード
        Boolean success = smDao.deleteMail(sendmail);

        if (success) {
            res.sendRedirect("admin_mail_delete_comp.jsp"); // 登録完了ページへ遷移
        } else {
            errors.put("database", "データベースエラーが発生しました。");
            session.setAttribute("errors", errors);
            res.sendRedirect("admin_mail_delete.jsp"); // 入力フォームページへ戻る
        }
	}
}
