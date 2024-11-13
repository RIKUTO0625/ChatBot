package login;

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
        String ad_pw = req.getParameter("ad_pw"); // パスワード
        String staff_belong = req.getParameter("staff_belong"); // 所属

        // DBへデータ保存
        Staff staff = sDao.findByMail(staff_mail);
        if (staff == null) { // 職員が未登録だった場合
            // スタッフインスタンスを初期化
            staff = new Staff();
            // インスタンスに値をセット
            staff.setAd_cd(ad_cd); // 組織コード
            staff.setStaff_name(staff_name); // 職員名
            staff.setStaff_mail(staff_mail); // 職員メールアドレス
            staff.setAd_pw(ad_pw); // パスワード
            staff.setAd_pw(staff_belong); // 所属

            // 職員情報を保存
            sDao.save(staff);
        } else { // 入力されたメールアドレスがDBに保存されていた場合
            req.setAttribute("error", "メールアドレスが重複しています");
            req.getRequestDispatcher("staff_create.jsp").forward(req, res);
            return;
        }

        // JSPへフォワード
        req.getRequestDispatcher("staff_create_pf.jsp").forward(req, res);
    }
}