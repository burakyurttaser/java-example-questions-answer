 package example.models;

public class Product {
	private Integer  id;
	private int amount;
	private double price;
	
	public Product() {

	}
	
	public Product(Integer id, int amount, double price) {
		super();
		this.id = id;
		this.amount = amount;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", amount=" + amount + ", price=" + price + "]";
	}
	
	

}
