package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class CreateDoctorExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // ローカル変数の宣言
        HttpSession session = req.getSession(); // セッション
        DoctorDao dDao = new DoctorDao(); // DoctorDaoを初期化
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

        String dc_name = req.getParameter("dc_name"); // 名前
        String dc_belong = req.getParameter("dc_belong"); // 所属
        String dc_dept = req.getParameter("dc_dept"); // 診断科
        String dc_pw = req.getParameter("dc_pw"); // パスワード

        // 入力値チェック
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

        // エラーがある場合は、エラーメッセージをセッションに保存して戻る
	    if (!errors.isEmpty()) {
	        session.setAttribute("errors", errors);
	        res.sendRedirect("doctor_create.jsp"); // 入力フォームページへ戻る
	        return;
	    }

        // 入力が正しければ、新しいスタッフオブジェクトを作成
        Doctor doctor = new Doctor();
        doctor.setDc_name(dc_name); // 名前
        doctor.setDc_belong(dc_belong); // 所属
        doctor.setDc_dept(dc_dept); // 診断か
        doctor.setDc_pw(dc_pw); // パスワード

        // データベースにスタッフ情報を保存
	    Boolean success = dDao.createDoctor(doctor);
	    if (success) {
	        res.sendRedirect("doctor_create_comp.jsp"); // 登録完了ページへ遷移
	    } else {
	        errors.put("database", "データベースエラーが発生しました。");
	        session.setAttribute("errors", errors);
	        res.sendRedirect("staff_doctor.jsp"); // 入力フォームページへ戻る
	    }
    }
}
