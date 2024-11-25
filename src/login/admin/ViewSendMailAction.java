package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class ViewSendMailAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		SendmailDao smDao = new SendmailDao();
		//リクエストパラメータ―の取得 2
		//なし
		//DBからデータ取得 3
		while(smDao.next){
		}
		//ビジネスロジック 4


		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7
		req.getRequestDispatcher("admin_mail_list.jsp").forward(req, res);
	}

}
