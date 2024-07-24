package example.test;

import java.util.Arrays;

import example.http.HttpExample;
import example.models.demo.DemoOrdersBuilder;
import example.models.questions.Questions;

public class TestApp {

	public static void main(String[] args) {
		final var price1 = Questions.getTotalOrderPrice(DemoOrdersBuilder.buildOrderId1000().getProductList());
		final var price2 = Questions.getTotalOrderPrice(DemoOrdersBuilder.buildOrderId1001().getProductList());
		final var price3 = Questions.getTotalOrderPrice(DemoOrdersBuilder.buildOrderId1002().getProductList());
		final var totalPrice = price1 + price2 + price3;

		System.out.println("Question 1: " + totalPrice);

		final var avarage = Questions.getAverageProductPrice(Arrays.asList(DemoOrdersBuilder.buildOrderId1000(),
				DemoOrdersBuilder.buildOrderId1001(), DemoOrdersBuilder.buildOrderId1002()));
		System.out.println("Question 2: " + avarage);

		final var tottalOrders = Arrays.asList(DemoOrdersBuilder.buildOrderId1000(),
				DemoOrdersBuilder.buildOrderId1001(), DemoOrdersBuilder.buildOrderId1002());

		System.out.println("Question 3: " + Questions.getAverageProductPriceAvarages(tottalOrders));

		System.out.println("Question 4: " + Questions.getProductCountForOrder(tottalOrders));

		final var getResponse = HttpExample.sendGetRequest("https://jsonplaceholder.typicode.com/posts/1");
		System.out.println("GET: " + getResponse);

		final var postResponse = HttpExample.sendPostRequest("https://jsonplaceholder.typicode.com/posts",
				"{\"name\": \"John\", \"age\": 30}");
		System.out.println("POST: " + postResponse);
	}

}
