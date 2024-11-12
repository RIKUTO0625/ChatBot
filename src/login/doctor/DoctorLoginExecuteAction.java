package login.doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class DoctorLoginExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		//なし
		//リクエストパラメータ―の取得 2
		//なし
		//DBからデータ取得 3
		//なし
		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7

//		エラーがあった場合ログイン画面へ戻る
//		if(){
//			req.getRequestDispatcher("doctor_login.jsp").forward(req, res);
//		}

		req.getRequestDispatcher("doctor_mypage.jsp").forward(req, res);
	}
}
