package bean;

import java.io.Serializable;


public class History implements Serializable{

	/**
	 * 回答数:Integer
	 */
	private Integer sum;

	/**
	 * 質問番号:Integer
	 */
	private Integer que_no;

	/**
	 * 返答番号:Integer
	 */
	private Integer ans_no;

	/**
	 * 年:String
	 */
	private String year;

	/**
	 * 年:String
	 */
	private String staff_id;

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
}