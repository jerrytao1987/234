package com.springdemo.jdbc;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Long custId;
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	private String custLinkman;
	private String custPhone;
	private String custMobile;
	private Set cstLinkmans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String custName, String custSource, String custIndustry, String custLevel, String custLinkman,
			String custPhone, String custMobile, Set cstLinkmans) {
		this.custName = custName;
		this.custSource = custSource;
		this.custIndustry = custIndustry;
		this.custLevel = custLevel;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.cstLinkmans = cstLinkmans;
	}

	// Property accessors

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return this.custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustry() {
		return this.custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustLinkman() {
		return this.custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public String getCustPhone() {
		return this.custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return this.custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Set getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

}