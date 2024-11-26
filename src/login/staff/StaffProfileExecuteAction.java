package login.staff;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class StaffProfileExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // ローカル変数の宣言 1
        HttpSession session = req.getSession(); // セッション
        StaffDao sDao = new StaffDao(); // スタッフDaoを初期化

        // リクエストパラメータ―の取得 2
        String staff_id = req.getParameter("staff_id"); // 職員番号
        String staff_name = req.getParameter("staff_name"); // 職員名
        String staff_age = req.getParameter("staff_age"); // 年齢
        String staff_belong = req.getParameter("staff_belong"); // 所属
        String staff_mail = req.getParameter("staff_mail"); // メールアドレス
        String gender_cd = req.getParameter("gender_cd"); // 性別
        String favorite = req.getParameter("favorite"); // 趣味
        String detail = req.getParameter("detail"); // 備考
        Map<String, String> errors = new HashMap<>(); // エラーメッセージ

        // DBからデータ取得 3
        Staff staff = sDao.get(staff_id); // 主キーのstaff_idから職員インスタンスを取得
        // レスポンス値をセット 6
	    // エラーチェック
        if (staff != null) {
        	 staff = new Staff();
        	 staff.setStaff_name(staff_name); //名前
             staff.setStaff_age(staff_age); //年齢
             staff.setStaff_belong(staff_belong); //所属
             staff.setStaff_mail(staff_mail); // メールアドレス
             staff.setGender_cd(gender_cd); // 性別コード
             staff.setFavorite(favorite); // 趣味
             staff.setDetail(detail); // 備考
             // 職員情報を保存
             sDao.save(staff);
        }
        // JSPへフォワード 7
        req.getRequestDispatcher("staff_profile_update.jsp").forward(req, res);
    }
}