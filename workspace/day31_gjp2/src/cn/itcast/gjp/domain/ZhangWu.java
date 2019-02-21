package cn.itcast.gjp.domain;

import java.util.Date;

public class ZhangWu {
	/*`zwid` int(11) NOT NULL AUTO_INCREMENT,
	  `flname` varchar(200) DEFAULT NULL,
	  `money` double DEFAULT NULL,
	  `zhanghu` varchar(100) DEFAULT NULL,
	  `createtime` date DEFAULT NULL,
	  `description` varchar(1000) DEFAULT NULL*/
	private Integer zwid;
	private String flname;
	private Double money;
	private String zhanghu;
	private Date createtime;
	private String description;
	public ZhangWu(Integer zwid, String flname, Double money, String zhanghu, Date createtime, String description) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.zhanghu = zhanghu;
		this.createtime = createtime;
		this.description = description;
	}
	public ZhangWu() {
	}
	public Integer getZwid() {
		return zwid;
	}
	public void setZwid(Integer zwid) {
		this.zwid = zwid;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return zwid + "\t" + flname + "\t" + money + "\t" + zhanghu
				+ "\t" + createtime + "\t" + description;
	}
	
}
