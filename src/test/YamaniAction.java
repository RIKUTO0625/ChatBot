package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.rds;
import tool.Action;

public class YamaniAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("テスト開始");

		rds test = new rds();

		test.select();

		req.getRequestDispatcher("yamani.jsp").forward(req, res);
	}
}
