package cn.itcast.ssh.pojo;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pname;
	private Double price;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String pname) {
		this.pname = pname;
	}

	/** full constructor */
	public Product(String pname, Double price) {
		this.pname = pname;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}