package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ReadExcelData;

public class ProductTest extends BaseTest {

	ReadExcelData readExcelData = new ReadExcelData();
	

	@SuppressWarnings("static-access")
	@DataProvider(name = "DataFromExcel")
	public Object[][] dataForTest() {
		return readExcelData.excelData;
	}

	@Test(dataProvider = "DataFromExcel")
	public void verifyGetRequest(String data1, String data2, String data3, String data4, String data5, String data6, String data7) {
		System.out.println("-----");
		System.out.println("datas");
		System.out.println(data1);
		System.out.println("-----");
//		System.out.println("data2 : ");
//		System.out.println(data2);
//		System.out.println("-----");
//		Assert.assertEquals(data1, "ab");
//		Assert.assertEquals(data2, "cd");
//		for(int i =1; i< data.size();i++) {
//			System.out.println("Data" + i);
//			System.out.println(data.get(i));
//		}

//		extentReport.createTestcase("Verify Get Product");
//		Response response =  bestBuyRequestPlant.getAllProducts("/products", "", 0);
//		extentReport.addLog(Status.INFO, response.asPrettyString());
//		response.then().statusCode(200);

	}

}
