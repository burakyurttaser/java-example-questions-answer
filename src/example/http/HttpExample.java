package example.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExample {

	public static String sendGetRequest(String urlString) {
		final StringBuilder response = new StringBuilder();
		try {
			final URL url = new URL(urlString);
			final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			final var responseCode = connection.getResponseCode();
			System.out.println("GET Response Code: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) {
				final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				System.out.println("GET request not worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.toString();
	}

	public static String sendPostRequest(String urlString, String jsonInputString) {
		final StringBuilder response = new StringBuilder();
		try {
			final URL url = new URL(urlString);
			final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);

			try (OutputStream os = connection.getOutputStream()) {
				final byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			final var responseCode = connection.getResponseCode();
			System.out.println("POST Response Code: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_CREATED) {
				final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
			} else {
				System.out.println("POST request not worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.toString();
	}
}