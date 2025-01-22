package login.doctor;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.ChatDao;
import dao.StaffDao;
import tool.Action;

public class UserLogAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッション
		StaffDao sDao = new StaffDao();
		ChatDao cDao = new ChatDao();
		Integer year;
		List<List<Integer>>staff_log = new ArrayList<>();	//質問の履歴リスト

		//リクエストパラメータ―の取得 2
		String staff_id = req.getParameter("no");
		String staff_pw = req.getParameter("pw");

		//DBからデータ取得 3
		Staff staff = sDao.loginStaff(staff_id, staff_pw);

		year = Year.now().getValue();

		staff_log = cDao.getHis(staff, year);
		System.out.println(staff_log);




		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		req.setAttribute("staffLog", staff_log);
        req.setAttribute("staff", staff);
		//JSPへフォワード 7
		req.getRequestDispatcher("user_log.jsp").forward(req, res);
	}
}
