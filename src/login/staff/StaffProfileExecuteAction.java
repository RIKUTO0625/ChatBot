package login.staff;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import tool.Action;

public class StaffProfileExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		 HttpSession session = req.getSession(); // セッション
	     StaffDao sDao = new StaffDao(); // スタッフDaoを初期化
	     Staff staff = null; //職員
	     Map<String, String> errors = new HashMap<>();//エラーメッセージ

		//リクエストパラメータ―の取得 2
	     String staff_id = req.getParameter("staff_id");//職員番号

		//DBからデータ取得 3
	     staff = sDao.get(staff_id);// 主キーのstaff_idから職員インスタンスを取得
		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
	    // DBへデータ保存
	    staff = new Staff();
        staff.setStaff_Name(staff_name); //
        staff.set_(); //
        staff.set_(); //
        staff.set_(); //
        staff.set_(); //
        staff.set_(); //
        staff.set_(); //
        // 職員情報を保存
        sDao.save(staff);

		//JSPへフォワード 7
		req.getRequestDispatcher("staffprofile.jsp").forward(req, res);
	}

}