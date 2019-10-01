package model;

public class Product {

	int id;
	String prodName;
	String quantity;
	
	
	
	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param prodName
	 * @param quantity
	 */
	public Product(int id, String prodName, String quantity) {
		this.id = id;
		this.prodName = prodName;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return prodName;
	}
	public void setName(String prodName) {
		this.prodName = prodName;
	}
	public String getCantitate() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
