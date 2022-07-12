package request;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {

	public static Response response;
	public static RequestSpecification responseSpecification = RestAssured.given().contentType(ContentType.JSON);
	public static String[] splitParameters;
	public static String[] splitjsonPaths;
	public static String headerValue;
	public static String[] splitStatusCode;
	public static String[] jsonValues;
	public static String[] splitHeaders;
	public static String[] headerValues;
	public void getProduct(String uri, String headers, String parameters, String statusCode, String jsonPaths) {
		splitHeaders = headers.split(",");
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
		
		for(String header: splitHeaders) {
			headerValues = header.split(":");
			headerValue = response.getHeader(headerValues[0]);
			Assert.assertEquals(headerValues[1], headerValue);
		}
		
		Assert.assertEquals(statusCode, response.statusCode());
		for(String jsonpath : splitjsonPaths) {
			jsonValues = jsonpath.split("=");
			Assert.assertEquals(response.jsonPath().getString(jsonpath),jsonValues[1]);
		}
	}

	public void postProduct() {

	}

	public void patchProduct() {

	}

	public void deleteProduct() {

	}

}
