package bean;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 組織コード:String
	 */
	private String ad_cd;

	/**
	 * 組織パスワード:String
	 */
	private String ad_pw;

	/**
	 * 組織名:String
	 */
	private String ad_name;


	/**
	 * 備考:Boolean
	 */
	private Boolean is_deleted;



	/**
	 * ゲッター、セッター
	 */

	public String getAd_cd() {
		return ad_cd;
	}

	public void setAd_cd(String ad_cd) {
		this.ad_cd = ad_cd;
	}

	public String getAd_pw() {
		return ad_pw;
	}

	public void setAd_pw(String ad_pw) {
		this.ad_pw = ad_pw;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public Boolean getIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


}