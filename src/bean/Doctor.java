package bean;

import java.io.Serializable;

public class Doctor extends Admin implements Serializable{

	/**
	 * Adminデータ:Admin
	 */
	private Admin admin;


	/**
	 * 医師パスワード:String
	 */
	private String cd_pw;


	/**
	 * 医師名:String
	 */
	private String cd_name;


	/**
	 * 医師所属:String
	 */
	private String cd_belong;


	/**
	 * 診療科:String
	 */
	private String cd_dept;


	/**
	 * ゲッター、セッター
	 */


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public String getCd_pw() {
		return cd_pw;
	}


	public void setCd_pw(String cd_pw) {
		this.cd_pw = cd_pw;
	}


	public String getCd_name() {
		return cd_name;
	}


	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}


	public String getCd_belong() {
		return cd_belong;
	}


	public void setCd_belong(String cd_belong) {
		this.cd_belong = cd_belong;
	}


	public String getCd_dept() {
		return cd_dept;
	}


	public void setCd_dept(String cd_dept) {
		this.cd_dept = cd_dept;
	}






}