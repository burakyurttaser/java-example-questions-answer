package example.models;

import java.util.List;

public class Order {
	private Integer orderId;
	private List<Product> productList;
	
	public Order() {
		super();
	}
	public Order(Integer orderId, List<Product> productList) {
		super();
		this.orderId = orderId;
		this.productList = productList;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productList=" + productList + "]";
	}
	
}
