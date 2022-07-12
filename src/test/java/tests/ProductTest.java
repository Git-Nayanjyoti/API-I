package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import request.RequestMethods;
import utils.ReadExcelData;

public class ProductTest extends BaseTest {

	ReadExcelData readExcelData = new ReadExcelData();
	RequestMethods request = new RequestMethods();

	@SuppressWarnings("static-access")
	@DataProvider(name = "DataFromExcel")
	public Object[][] dataForTest() {
		return readExcelData.excelData;
	}

	@Test(dataProvider = "DataFromExcel")
	public void validateRequest(String requestType, String requestURI, String requestHeaders, String requestBody,
			String requestParameters, String expectedStatusCode, String jsonPath) {
		switch (requestType) {
		case "GET":
			request.getProduct(requestURI, requestHeaders, requestParameters, expectedStatusCode, jsonPath);
			break;

		case "POST":
			request.postProduct(requestURI, requestHeaders, requestBody, expectedStatusCode);
			break;

		case "PUT":
			request.putProduct(requestURI, requestHeaders, requestBody, requestParameters, expectedStatusCode);
			break;

		case "PATCH":
			request.patchProduct(requestURI, requestHeaders, requestBody, requestParameters, expectedStatusCode);
			break;
		case "DELETE":
			request.deleteProduct(requestURI, requestHeaders, requestBody, requestParameters, expectedStatusCode);
			break;

		default:
			break;
		}

	}

}
