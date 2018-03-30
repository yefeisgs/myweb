package cn.ahyd.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date; // CTRL + Tree
// 所有的类默认都集成object

public class Product extends Object implements Serializable {



	public Product() {
		this.name = name;
		this.date = date;
	}

	private static final long serialVersionUID = -7523703073385830185L;

	private Integer id; // int id
	private String name;
	private BigDecimal price;
	private String pic;
	private String remark;
	private Date date;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", pic=" + pic + ", remark=" + remark + ", date=" + date
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName.......");
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
