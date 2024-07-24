package example.models.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import example.models.Order;
import example.models.Product;

public class Questions {

	public static double getTotalOrderPrice(List<Product> products) {
		return products.stream().mapToDouble(product -> product.getPrice() * product.getAmount()).sum();
	}

	public static double getAverageProductPrice(List<Order> orders) {
		return orders.stream().flatMap(order -> order.getProductList().stream()).mapToDouble(Product::getPrice)
				.average().orElse(0.0);
	}

	public static Map<Integer, Double> getAverageProductPriceAvarages(List<Order> orders) {

		final Map<Integer, Double> totalPrices = new HashMap<>();
		final Map<Integer, Integer> counts = new HashMap<>();
		final Map<Integer, Double> averagePrices = new HashMap<>();

		for (Order order : orders) {
			for (int j = 0; j < order.getProductList().size(); j++) {
				totalPrices.put(order.getProductList().get(j).getId(),
						totalPrices.getOrDefault(order.getProductList().get(j).getId(), 0.0)
								+ order.getProductList().get(j).getPrice());
				counts.put(order.getProductList().get(j).getId(),
						counts.getOrDefault(order.getProductList().get(j).getId(), 0) + 1);
			}
		}

		for (Map.Entry<Integer, Double> entry : totalPrices.entrySet()) {
			Integer productId = entry.getKey();
			Double totalPrice = entry.getValue();
			Integer count = counts.get(productId);
			averagePrices.put(productId, totalPrice / count);
		}

		return averagePrices;
	}

	public static Map<Integer, Map<Integer, Integer>> getProductCountForOrder(List<Order> orders) {
		final Map<Integer, Map<Integer, Integer>> productOrderMap = new HashMap<>();

		for (Order order : orders) {
			int orderId = order.getOrderId();
			for (Product product : order.getProductList()) {
				final int productId = product.getId();
				final int amount = product.getAmount();

				if (productOrderMap.containsKey(productId)) {
					final Map<Integer, Integer> orderMap = productOrderMap.get(productId);
					orderMap.put(orderId, orderMap.getOrDefault(orderId, 0) + amount);
				} else {
					final Map<Integer, Integer> orderMap = new HashMap<>();
					orderMap.put(orderId, amount);
					productOrderMap.put(productId, orderMap);
				}
			}
		}

		return productOrderMap;
	}
}
