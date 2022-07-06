package tests;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import request.BestBuyRequestPlant;

public class ProductTest {
	
	BestBuyRequestPlant bestBuyRequestPlant;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;
		
		bestBuyRequestPlant = new BestBuyRequestPlant();
	}
	
	@Test
	public void verifyGetRequest() {
		bestBuyRequestPlant.getAllProducts().then().log().all().statusCode(200);
	}

}
