package bean;

import java.io.Serializable;

public class Staff extends Admin implements Serializable{


	/**
	 * 職員番号:String
	 */
	private String staff_id;


	/**
	 * 職員パスワード:String
	 */
	private String staff_pw;


	/**
	 * Adminデータ:Admin
	 */
	private Admin admin;


	/**
	 * 職員年齢:String
	 */
	private Integer staff_age;


	/**
	 * 職員名:String
	 */
	private String staff_name;


	/**
	 * 所属部署:String
	 */
	private String staff_belong;


	/**
	 * メールアドレス:String
	 */
	private String staff_mail;

	/**
	 * 性別コード:String
	 */
	private String gender_cd;

	/**
	 * 趣味:String
	 */
	private String favorite;

	/**
	 * 備考:String
	 */
	private String detail;



	/**
	 * ゲッター、セッター
	 */

	public String getGender_cd() {
		return gender_cd;
	}


	public void setGender_cd(String gender_cd) {
		this.gender_cd = gender_cd;
	}


	public String getFavorite() {
		return favorite;
	}


	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}


	public String getStaff_pw() {
		return staff_pw;
	}


	public void setStaff_pw(String staff_pw) {
		this.staff_pw = staff_pw;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public Integer getStaff_age() {
		return staff_age;
	}


	public void setStaff_age(Integer staff_age) {
		this.staff_age = staff_age;
	}


	public String getStaff_name() {
		return staff_name;
	}


	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}


	public String getStaff_belong() {
		return staff_belong;
	}


	public void setStaff_belong(String staff_belong) {
		this.staff_belong = staff_belong;
	}


	public String getStaff_mail() {
		return staff_mail;
	}


	public void setStaff_mail(String staff_mail) {
		this.staff_mail = staff_mail;
	}


}