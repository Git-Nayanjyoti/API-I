package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

public class ProductTest extends BaseTest {

	@DataProvider(name = "DataFromExcel")
	public List<String> dataForTest() {
		List<String> list = new ArrayList<String>();
		return list;
	}

	@Test(dataProvider = "")
	public void verifyGetRequest() {
		extentReport.createTestcase("Verify Get Product");
		Response response =  bestBuyRequestPlant.getAllProducts("/products", "", 0);
		extentReport.addLog(Status.INFO, response.asPrettyString());
		response.then().statusCode(200);
	}

}
