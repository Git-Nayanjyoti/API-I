package request;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {

	public static Response response;
	public static RequestSpecification responseSpecification = RestAssured.given().contentType(ContentType.JSON).when();
	public static String[] splitParameters;
	public static String[] splitjsonPaths;
	public static String[] splitStatusCode;
	public static String[] splitHeaders;
	
	public static String[] jsonValues;
	public static String[] headerValues;
	
	public static String headerValue;
	
	//method for validating Headers
	public void validateHeaders(String[] headers) {
		for(String header: headers) {
			headerValues = header.split(":");
			headerValue = response.getHeader(headerValues[0]);
			Assert.assertEquals(headerValues[1], headerValue);
		}
	}
	
	//method for validating jsonPath
	public void validateJsonPaths(String[] jsonPaths) {
		for(String jsonpath : jsonPaths) {
			jsonValues = jsonpath.split("=");
			Assert.assertEquals(response.jsonPath().getString(jsonpath),jsonValues[1]);
		}
	}
	
	//method for request type GET
	public void getProduct(String uri, String headers, String parameters, String statusCode, String jsonPaths) {
		splitHeaders = headers.split(",");
		splitParameters = parameters.split(",");
		splitjsonPaths = jsonPaths.split(",");
		response = responseSpecification
				.queryParam(splitParameters[0], Integer.parseInt(splitParameters[1]))
				.get(uri)
				.then()
				.extract()
				.response();
		
		//validating headers 
		//calling headers validation function
		validateHeaders(splitHeaders);
		
		//validating jsonpath 
		//calling jsonpath validation function
		validateJsonPaths(splitjsonPaths);
		
		//validating status code
		Assert.assertEquals(statusCode, response.statusCode());
	}

	//method for request type POST
	public void postProduct() {

	}

	//method for request type PATCH
	public void patchProduct() {

	}

	//method for request type DELETE
	public void deleteProduct(String uri,String requestHeaders, String headerBody,String parameter, String statusCode) {
		splitHeaders = requestHeaders.split(",");
		splitStatusCode = statusCode.split(",");
		response = responseSpecification
				.body(headerBody)
				.post(uri)
				.then()
				.extract()
				.response();
		int productId = response.path(parameter);
		int statusCodeOnDelete = responseSpecification.delete(parameter + productId).then().extract().response().statusCode();
		int statusCodeOnGet = responseSpecification.get(parameter + productId).then().extract().response().statusCode();

		//validating headers
		//calling the header validation method
		validateHeaders(splitHeaders);
		
		//validating the DELETE post status code
		Assert.assertEquals(splitStatusCode[0], statusCodeOnDelete);
		
		//Also checking it by requesting a get request of the same data and validating the status code. As it will not be there it will return 400
		Assert.assertEquals(splitStatusCode[1], statusCodeOnGet);
	}

}
