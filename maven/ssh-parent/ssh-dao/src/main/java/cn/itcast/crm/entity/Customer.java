package cn.itcast.crm.entity;

public class Customer {
	/*CREATE TABLE `cst_customer` (
			  `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
			  `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
			  `cust_user_id` BIGINT(32) DEFAULT NULL COMMENT '负责人id',
			  `cust_create_id` BIGINT(32) DEFAULT NULL COMMENT '创建人id',
			  `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
			  `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
			  `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
			  `cust_linkman` VARCHAR(64) DEFAULT NULL COMMENT '联系人',
			  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '固定电话',
			  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '移动电话',
			  `cust_createtime` DATETIME DEFAULT NULL COMMENT '创建时间',*/
	private Long custId;
	private String custName;
	private Long custUserId;
	private Long custCreateId;
	private String custIndustry;
	private String custLevel;
	private String custLinkman;
	private String custPhone;
	private String custMobile;
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getCustUserId() {
		return custUserId;
	}
	public void setCustUserId(Long custUserId) {
		this.custUserId = custUserId;
	}
	public Long getCustCreateId() {
		return custCreateId;
	}
	public void setCustCreateId(Long custCreateId) {
		this.custCreateId = custCreateId;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
}
