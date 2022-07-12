package request;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {

	public static Response response;
	public static RequestSpecification responseSpecification = RestAssured.given();
	public static String[] splitParameters;
	public static String[] splitjsonPaths;
	public void getProduct(String uri, String headers, String parameters, String statusCode, String jsonPaths) {
		splitParameters = parameters.split(",");
		splitjsonPaths = jsonPaths.split(",");
		response = responseSpecification
				.when()
				.queryParam(splitParameters[0], Integer.parseInt(splitParameters[1]))
				.get(uri)
				.then()
				.log()
				.all()
				.extract()
				.response();
		String headerValue = response.getHeader("Content-Type");
		Assert.assertEquals("application/json; charset=utf-8", headerValue);
		Assert.assertEquals(statusCode, response.statusCode());
		for(String jsonpath : splitjsonPaths) {
			Assert.assertEquals(response.jsonPath().getString(jsonpath),"Duracell - AAA Batteries (4-Pack)");
		}
	}

	public void postProduct() {

	}

	public void patchProduct() {

	}

	public void deleteProduct() {

	}

}
