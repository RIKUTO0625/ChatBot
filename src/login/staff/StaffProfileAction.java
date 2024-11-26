package login.staff;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class StaffProfileAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		 HttpSession session = req.getSession(); // セッション
	     StaffDao sDao = new StaffDao(); // スタッフDaoを初期化
	     Staff staff = null; //職員
	     Map<String, String> errors = new HashMap<>();//エラーメッセージ

		//リクエストパラメータ―の取得 2
	     String staff_id = req.getParameter("staff_id");//職員番号
	     String staff_name = req.getParameter("staff_name");//名前
	     String staff_age = req.getParameter("staff_age");//年齢
	     String gender_cd = req.getParameter("gender_cd");//性別
	     String staff_belong = req.getParameter("staff_belong");//所属
	     String staff_mail = req.getParameter("staff_mail");//連絡先
	     String favorite = req.getParameter("favorite");//趣味
	     String detail = req.getParameter("detail");//備考

		//DBからデータ取得 3
	     staff = sDao.get(staff_id);// 主キーのstaff_idから職員インスタンスを取得
		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
	     if (staff != null) {// 職員が存在していた場合
				req.setAttribute("staff_name", staff.getstaff_name());//名前
				req.setAttribute("staff_age", staff.getstaff_age());//年齢
				req.setAttribute("gender_cd", staff.getgender_cd());//性別
				req.setAttribute("staff_belong", staff.getstaff_belong());//所属
				req.setAttribute("staff_mail", staff.getstaff_mail());//連絡先
				req.setAttribute("favorite", staff.getfavorite());//趣味
				req.setAttribute("detail", staff.getdetail());//備考
	     } else {// 職員が存在していなかった場合
				errors.put("staff_id", "職員が存在していません");
				req.setAttribute("errors", errors);
			}

		//JSPへフォワード 7
		req.getRequestDispatcher("staff_profile.jsp").forward(req, res);
	}

}


