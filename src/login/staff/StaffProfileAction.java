package login.staff;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import tool.Action;

public class StaffProfileAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // セッションからログイン中のスタッフ情報を取得
        HttpSession session = req.getSession(); // セッション取得
        Map<String, String> errors = new HashMap<>(); // エラーメッセージ

        // セッションから"staff"という名前でStaffオブジェクトを取得
        Staff staff = (Staff) session.getAttribute("user");

        // ビジネスロジック
        if (staff != null) {
            // スタッフ情報をリクエストスコープに設定
        	req.setAttribute("staff_name", staff.getStaff_name()); // 名前
        	req.setAttribute("staff_age", staff.getStaff_age());   // 年齢
        	req.setAttribute("gender_cd", staff.getGender_cd());   // 性別
        	req.setAttribute("staff_belong", staff.getStaff_belong()); // 所属
        	req.setAttribute("staff_mail", staff.getStaff_mail());   // 連絡先
            req.setAttribute("favorite", staff.getFavorite());      // 趣味
            req.setAttribute("detail", staff.getDetail());          // 備考
        } else {
            // スタッフ情報が存在しない場合
            errors.put("staff_id", "職員が存在していません");
            req.setAttribute("errors", errors);
        }

        // JSPへフォワード
        req.getRequestDispatcher("staff_profile.jsp").forward(req, res);
    }
}
