package bean;

import java.io.Serializable;

public class SendMail extends Admin implements Serializable{


	/**
	 * メールアドレス番号:String
	 */
	private String mail_id;


	/**
	 * Adminデータ:Admin
	 */
	private Admin admin;


	/**
	 * メールアドレス:String
	 */
	private String send_mail;

	/**
	 * ゲッター、セッター
	 */

	public String getMail_id() {
		return mail_id;
	}


	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public String getSend_mail() {
		return send_mail;
	}


	public void setSend_mail(String send_mail) {
		this.send_mail = send_mail;
	}



}