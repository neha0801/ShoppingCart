package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CART database table.
 * 
 */
@Entity
@Table(name="Cart",schema="testDB")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long cartid;

	private int quantity;

	private int status;

	private Double totalprice;

	private String useremail;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	public Cart() {
	}

	public long getCartid() {
		return this.cartid;
	}

	public void setCartid(long cartid) {
		this.cartid = cartid;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}