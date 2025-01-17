package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class CreateDoctorExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        DoctorDao dDao = new DoctorDao();
        Map<String, String> errors = new HashMap<>();

        try {
            // フォームデータの取得
            String admin_str = req.getParameter("admin"); // 管理者コード
            String dc_name = req.getParameter("dc_name"); // 職員名
            String dc_belong = req.getParameter("dc_belong"); // 所属
            String dc_dept = req.getParameter("dc_dept"); // 診断科
            String dc_pw = req.getParameter("dc_pw"); // パスワード

            // 入力値チェック
            if (admin_str == null || admin_str.isEmpty()) {
                errors.put("admin", "管理者コードを入力してください。");
            }
            if (dc_name == null || dc_name.isEmpty()) {
                errors.put("dc_name", "名前を入力してください。");
            }
            if (dc_belong == null || dc_belong.isEmpty()) {
                errors.put("dc_belong", "所属を入力してください。");
            }
            if (dc_dept == null || dc_dept.isEmpty()) {
                errors.put("dc_dept", "診断科を入力してください。");
            }
            if (dc_pw == null || dc_pw.isEmpty()) {
                errors.put("dc_pw", "パスワードを入力してください。");
            }

            // Adminオブジェクトを作成
            Admin admin = new Admin();
            admin.setAd_cd(admin_str);
            System.out.println("admin中身"+admin);//確認
            System.out.println("admin_str中身"+admin_str);//確認

            // Doctorオブジェクトを作成
            Doctor doctor = new Doctor();
            doctor.setAdmin(admin); // 管理者コードをセット
            doctor.setDc_name(dc_name); // 名前をセット
            doctor.setDc_belong(dc_belong); // 所属をセット
            doctor.setDc_dept(dc_dept); // 診断科をセット
            doctor.setDc_pw(dc_pw); // パスワードをセット
            System.out.println("中身"+doctor);//確認

            // データベース処理
            boolean success = dDao.createDoctor(doctor);
            if (success) {
            	System.out.println("if (success)");
                res.sendRedirect("doctor_create_comp.jsp"); // 登録完了ページへ遷移
            } else {
            	System.out.println("else");
                // 作成に失敗した場合の処理
                session.setAttribute("errorMessage", "作成に失敗しました。管理者コードが間違っています。");
                res.sendRedirect("doctor_create.jsp"); // エラーメッセージを持ったまま戻る
            }
        } catch (Exception e) {
        	System.out.println("catch (Exception e)");
            // 例外発生時の処理
            e.printStackTrace(); // ログに詳細を出力（本番環境では適切なログ出力を行う）
            session.setAttribute("errorMessage", "作成中にエラーが発生しました。");
            res.sendRedirect("doctor_create.jsp"); // エラーメッセージを持ったまま戻る
        }
    }
}
