package bean;

import java.io.Serializable;
import java.sql.Date;


public class Chat implements Serializable{

	/**
	 * 会話番号:Integer
	 */
	private Integer chat_no;

	/**
	 * 質問番号:Integer
	 */
	private Integer que_no;

	/**
	 * 返答番号:Integer
	 */
	private Integer ans_no;

	/**
	 * 組織コード:String
	 */
	private String ad_cd;

	/**
	 * 日付:Time
	 */
	private Date date;

	/**
	 * 職員番号:String
	 */
	private String staff_id;

	/**
	 * ゲッター、セッター
	 */

	public Integer getChat_no() {
		return chat_no;
	}

	public void setChat_no(Integer chat_no) {
		this.chat_no = chat_no;
	}

	public Integer getQue_no() {
		return que_no;
	}

	public void setQue_no(Integer que_no) {
		this.que_no = que_no;
	}

	public Integer getAns_no() {
		return ans_no;
	}

	public void setAns_no(Integer ans_no) {
		this.ans_no = ans_no;
	}

	public String getAd_cd() {
		return ad_cd;
	}

	public void setAd_cd(String ad_cd) {
		this.ad_cd = ad_cd;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}


}