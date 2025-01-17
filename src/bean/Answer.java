package bean;

import java.io.Serializable;


public class Answer implements Serializable{

	/**
	 * 返答番号:Intger
	 */
	private Integer ans_no;

	/**
	 * 選択内容:
	 */
	private String ans_text;


	/**
	 * ゲッター、セッター
	 */

	public Integer getAns_no() {
		return ans_no;
	}

	public void setAns_no(Integer ans_no) {
		this.ans_no = ans_no;
	}

	public String getAns_text() {
		return ans_text;
	}

	public void setAns_text(String ans_text) {
		this.ans_text = ans_text;
	}



}
