package cn.itcast.ssh.pojo;

/**
 * Zhangwu entity. @author MyEclipse Persistence Tools
 */

public class Zhangwu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double money;

	// Constructors

	/** default constructor */
	public Zhangwu() {
	}

	/** full constructor */
	public Zhangwu(String name, Double money) {
		this.name = name;
		this.money = money;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}