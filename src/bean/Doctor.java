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
	private String dc_pw;


	/**
	 * 医師名:String
	 */
	private String dc_name;


	/**
	 * 医師所属:String
	 */
	private String dc_belong;


	/**
	 * 診療科:String
	 */
	private String dc_dept;

	/**
	 * 備考:Boolean
	 */
	private Boolean is_deleted;


	/**
	 * ゲッター、セッター
	 */


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public String getDc_pw() {
		return dc_pw;
	}


	public void setDc_pw(String dc_pw) {
		this.dc_pw = dc_pw;
	}


	public String getDc_name() {
		return dc_name;
	}


	public void setDc_name(String dc_name) {
		this.dc_name = dc_name;
	}


	public String getDc_belong() {
		return dc_belong;
	}


	public void setDc_belong(String dc_belong) {
		this.dc_belong = dc_belong;
	}


	public String getDc_dept() {
		return dc_dept;
	}


	public void setDc_dept(String dc_dept) {
		this.dc_dept = dc_dept;
	}

	public Boolean getIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


}