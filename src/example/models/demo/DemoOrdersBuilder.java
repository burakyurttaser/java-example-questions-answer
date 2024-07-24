package example.models.demo;

import java.util.Arrays;

import example.models.Order;
import example.models.Product;

public class DemoOrdersBuilder {

	public static Order buildOrderId1000() {

		final Order order1 = new Order();

		order1.setOrderId(1000);

		final Product product1 = new Product(2000, 12, 100.51);
		final Product product2 = new Product(2001, 31, 200);
		final Product product3 = new Product(2002, 22, 150.86);
		final Product product4 = new Product(2003, 41, 250);
		final Product product5 = new Product(2004, 55, 244);

		order1.setProductList(Arrays.asList(product1, product2, product3, product4, product5));

		return order1;
	}

	public static Order buildOrderId1001() {
		final Order order2 = new Order();
		order2.setOrderId(1001);

		final Product product1 = new Product(2001, 88, 44.531);
		final Product product2 = new Product(2002, 121, 88.11);
		final Product product3 = new Product(2004, 74, 211);
		final Product product4 = new Product(2002, 14, 88.11);

		order2.setProductList(Arrays.asList(product1, product2, product3, product4));
		return order2;
	}

	public static Order buildOrderId1002() {
		final Order order3 = new Order();
		order3.setOrderId(1002);

		final Product product1 = new Product(2003, 2, 12.1);
		final Product product2 = new Product(2004, 3, 22.3);
		final Product product3 = new Product(2003, 8, 12.1);
		final Product product4 = new Product(2002, 16, 94);
		final Product product5 = new Product(2005, 9, 44.1);
		final Product product6 = new Product(2006, 19, 90);

		order3.setProductList(Arrays.asList(product1, product2, product3, product4, product5, product6));
		return order3;
	}

}
