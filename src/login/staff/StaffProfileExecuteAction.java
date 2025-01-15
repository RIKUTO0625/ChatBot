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

        // セッションからstaff_idを取得
        Staff staff = (Staff) session.getAttribute("user"); // セッションから職員番号を取得

        // リクエストパラメータ―の取得 2
        String staff_name = req.getParameter("staff_name"); // 職員名
        String staff_age = req.getParameter("staff_age"); // 年齢
        String staff_belong = req.getParameter("staff_belong"); // 所属
        String staff_mail = req.getParameter("staff_mail"); // メールアドレス
        String gender_cd = req.getParameter("gender_cd"); // 性別
        String favorite = req.getParameter("favorite"); // 趣味
        String detail = req.getParameter("detail"); // 備考

        Map<String, String> errors = new HashMap<>(); // エラーメッセージ
        // スタッフが存在する場合に情報を更新 4
        if (staff != null) {
            // 入力された情報をstaffオブジェクトにセット
            staff.setStaff_name(staff_name); // 名前
            staff.setStaff_age(staff_age != null && !staff_age.isEmpty() ? Integer.parseInt(staff_age) : null); // 年齢（nullチェック）
            staff.setStaff_belong(staff_belong); // 所属
            staff.setStaff_mail(staff_mail); // メールアドレス
            staff.setGender_cd(gender_cd); // 性別コード
            staff.setFavorite(favorite); // 趣味
            staff.setDetail(detail); // 備考

            // エラーチェック
            if (staff_name == null || staff_name.isEmpty()) {
                errors.put("staff_name", "名前を入力してください。");
            }
            if (staff_age == null || staff_age.isEmpty()) {
                errors.put("staff_age", "年齢を入力してください。");
            }
            if (staff_belong == null || staff_belong.isEmpty()) {
                errors.put("staff_belong", "所属を入力してください。");
            }
            if (staff_mail == null || staff_mail.isEmpty()) {
                errors.put("staff_mail", "メールアドレスを入力してください。");
            }
            if (gender_cd == null || gender_cd.isEmpty()) {
                errors.put("gender_cd", "性別を入力してください。");
            }

            // エラーがない場合、データを更新
            if (errors.isEmpty()) {
                // 職員情報を更新（保存）
                sDao.editStaff(staff);
                // 更新完了後にリダイレクトする場合など（例えば、成功メッセージを表示）
                req.setAttribute("successMessage", "プロフィールが更新されました。");
            } else {
                // エラーがある場合はエラーメッセージをリクエストにセット
                req.setAttribute("errors", errors);
            }
        } else {
            // スタッフが見つからなかった場合a
            req.setAttribute("errorMessage", "スタッフ情報が見つかりません。");
        }
        // JSPへフォワード 7
        req.getRequestDispatcher("staff_profile_comp.jsp").forward(req, res);
    }
}
