package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {

	public static Response response;
	public static RequestSpecification responseSpecification = RestAssured.given();

	public void getProduct(String uri, String headers, String parameters, String statusCode, String jsonPath) {

		response = responseSpecification
				.when()
				.queryParam("$limit", 1)
				.get(uri)
				.then()
				.log()
				.all()
				.extract()
				.response();
	}

	public void postProduct() {

	}

	public void patchProduct() {

	}

	public void deleteProduct() {

	}

}
