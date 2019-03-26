package cn.itcast.ssh.pojo;

/**
 * Sort entity. @author MyEclipse Persistence Tools
 */

public class Sort implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String sname;
	private Double sprice;
	private String sdesc;

	// Constructors

	/** default constructor */
	public Sort() {
	}

	/** full constructor */
	public Sort(String sname, Double sprice, String sdesc) {
		this.sname = sname;
		this.sprice = sprice;
		this.sdesc = sdesc;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Double getSprice() {
		return this.sprice;
	}

	public void setSprice(Double sprice) {
		this.sprice = sprice;
	}

	public String getSdesc() {
		return this.sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

}