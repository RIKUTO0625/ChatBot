package login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import tool.Action;

public class CreateStaffExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // ローカル変数の宣言
        HttpSession session = req.getSession(); // セッション
        StaffDao sDao = new StaffDao(); // スタッフDaoを初期化

        String ad_cd = req.getParameter("ad_cd"); // 組織コード
        String staff_name = req.getParameter("staff_name"); // 職員名
        String staff_mail = req.getParameter("staff_mail"); // 職員メールアドレス
        String staff_pw = req.getParameter("staff_pw"); // パスワード
        String staff_belong = req.getParameter("staff_belong"); // 所属
        Staff staff = null; //職員
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

        // DBへデータ保存
        staff = sDao.get(staff_pw);// 主キーのパスワードから医者インスタンスを取得
        if (staff == null) { // 職員が未登録だった場合
            // スタッフインスタンスを初期化
            staff = new Staff();
            // インスタンスに値をセット
            staff.setAd_cd(ad_cd); // 組織コード
            staff.setStaff_name(staff_name); // 職員名
            staff.setStaff_mail(staff_mail); // 職員メールアドレス
            staff.setAd_pw(staff_pw); // パスワード
            staff.setStaff_belong(staff_belong); // 所属
            // 職員情報を保存
            sDao.save(staff);
        } else { // 入力されたメールアドレスがDBに保存されていた場合
        	errors.put("staff_pw", "パスワードが重複します");
            return;
        }

        // JSPへフォワード
        req.getRequestDispatcher("staff_create_pf.jsp").forward(req, res);
    }
}
