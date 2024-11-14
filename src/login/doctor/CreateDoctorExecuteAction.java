package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Doctor;
import tool.Action;

public class CreateDoctorExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // ローカル変数の宣言
        HttpSession session = req.getSession(); // セッション
        DoctorDao dDao = new DoctorDao(); // DoctorDaoを初期化

        String dc_name = req.getParameter("dc_name"); // 名前
        String dc_belong = req.getParameter("dc_belong"); // 所属
        String dc_dept = req.getParameter("dc_dept"); // 診断科
        String dc_pw = req.getParameter("dc_pw"); // パスワード
        Doctor doctor = null;//医者
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

        doctor = dDao.get(dc_pw);// 主キーのパスワードから医者インスタンスを取得

        // DBへデータ保存
        if (doctor == null){
        	// 医者インスタンスを初期化
            doctor = new Doctor();
            // インスタンスに値をセット
	        doctor.setDc_name(dc_name); // 医師名
	        doctor.setDc_belong(dc_belong); // 所属
	        doctor.setDc_dept(dc_dept); // 診断科
	        doctor.setDc_pw(dc_pw); // パスワード
	        // 医師情報を保存
	        dDao.save(doctor);
        }else {//入力された学番がDBに保存されていた場合
			errors.put("dc_pw", "パスワードが重複します");
		}

        // JSPへフォワード
        req.getRequestDispatcher("doctor_create_pf.jsp").forward(req, res);
    }
}
