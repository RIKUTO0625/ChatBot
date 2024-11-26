package login.staff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class UserAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッション
		StaffDao sDao = new StaffDao();
		List<Staff> staffs = null;

		//リクエストパラメータ―の取得 2
		String name = req.getParameter("name");

		//DBからデータ取得 3

        if (name != null && !name.isEmpty()) {
            // 名前で検索
            staffs = sDao.search(name);
        } else {
            // 全リスト表示
            staffs = sDao.view();
        }

		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
        req.setAttribute("staffs", staffs);
		//JSPへフォワード 7
		req.getRequestDispatcher("user_list.jsp").forward(req, res);
	}
}
