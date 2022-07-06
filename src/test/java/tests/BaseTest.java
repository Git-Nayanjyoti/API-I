package tests;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import request.BestBuyRequestFactory;
import utils.ConfigRead;
import utils.ExtentReportUtils;

public class BaseTest {
	String configFilename;
	Properties configProperties;
	BestBuyRequestFactory bestBuyRequestPlant;
	String currentWorkingDirectory;
	String htmlReportFilename;
	ExtentReportUtils extentReport;
	
	@BeforeSuite
	public void preSetup() throws IOException {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFilename = currentWorkingDirectory + "/src/test/resources/config/config.properties";
		configProperties = ConfigRead.readConfigProperties(configFilename);
		htmlReportFilename = currentWorkingDirectory + "/src/test/resources/reports/htmlReport.html";
		extentReport = new ExtentReportUtils(htmlReportFilename);
	}
	
	@BeforeClass
	public void setup() {
		extentReport.createTestcase("Setup : Update all configuration");
		RestAssured.baseURI = configProperties.getProperty("baseUrl");
		RestAssured.port = Integer.parseInt(configProperties.getProperty("port"));
		
		bestBuyRequestPlant = new BestBuyRequestFactory();
		
		extentReport.addLog(Status.INFO, "Base Url - " +  configProperties.getProperty("baseUrl"));
		extentReport.addLog(Status.INFO, "Base Url - " +  Integer.parseInt(configProperties.getProperty("port")));
	}
	
	@AfterClass
	public void clear() {
		RestAssured.reset();
		extentReport.closeReports();
	}

}
