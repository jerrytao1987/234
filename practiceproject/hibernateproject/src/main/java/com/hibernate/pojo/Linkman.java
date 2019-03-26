package com.hibernate.pojo;

/**
 * Linkman entity. @author MyEclipse Persistence Tools
 */

public class Linkman implements java.io.Serializable {

	// Fields

	private Long lkmId;
	private Customer customer;
	private String lkmGender;
	private String lkmName;
	private String lkmPhone;
	private String lkmMobile;
	private String lkmEmail;
	private String lkmQq;
	private String lkmPosition;
	private String lkmMemo;

	// Constructors

	/** default constructor */
	public Linkman() {
	}

	/** full constructor */
	public Linkman(Customer customer, String lkmGender, String lkmName, String lkmPhone, String lkmMobile,
			String lkmEmail, String lkmQq, String lkmPosition, String lkmMemo) {
		this.customer = customer;
		this.lkmGender = lkmGender;
		this.lkmName = lkmName;
		this.lkmPhone = lkmPhone;
		this.lkmMobile = lkmMobile;
		this.lkmEmail = lkmEmail;
		this.lkmQq = lkmQq;
		this.lkmPosition = lkmPosition;
		this.lkmMemo = lkmMemo;
	}

	// Property accessors

	public Long getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLkmGender() {
		return this.lkmGender;
	}

	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}

	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmPhone() {
		return this.lkmPhone;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	public String getLkmMobile() {
		return this.lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmEmail() {
		return this.lkmEmail;
	}

	public void setLkmEmail(String lkmEmail) {
		this.lkmEmail = lkmEmail;
	}

	public String getLkmQq() {
		return this.lkmQq;
	}

	public void setLkmQq(String lkmQq) {
		this.lkmQq = lkmQq;
	}

	public String getLkmPosition() {
		return this.lkmPosition;
	}

	public void setLkmPosition(String lkmPosition) {
		this.lkmPosition = lkmPosition;
	}

	public String getLkmMemo() {
		return this.lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

}