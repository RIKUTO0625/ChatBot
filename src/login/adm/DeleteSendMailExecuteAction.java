package login.adm;

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

		Map<String, String> errors = new HashMap<>();// エラーメッセージ

		SendMail sendmail = (SendMail)session.getAttribute("sendmail");// メールを取得

        if (sendmail != null) {

			smDao.deleteMail(sendmail);

			session.removeAttribute("sendmail");

            res.sendRedirect("adm_mail_delete_comp.jsp"); // 削除完了ページへ遷移
        } else {
            errors.put("database", "データベースエラーが発生しました。");
            session.setAttribute("errors", errors);
            res.sendRedirect("adm_mail_list.jsp"); // メール一覧画面へ戻る
        }
	}
}
