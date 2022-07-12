package tests;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import request.RequestMethods;
import utils.ConfigRead;

public class BaseTest {
	String configFilename;
	Properties configProperties;
	RequestMethods requestMethods;
	String currentWorkingDirectory;
	
	@BeforeSuite
	public void preSetup() throws IOException {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFilename = currentWorkingDirectory + "/src/test/resources/config/config.properties";
		configProperties = ConfigRead.readConfigProperties(configFilename);
	}
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = configProperties.getProperty("baseUrl");
		RestAssured.port = Integer.parseInt(configProperties.getProperty("port"));
		
		requestMethods = new RequestMethods();
		
	}
	
	@AfterClass
	public void clear() {
		RestAssured.reset();
	}

}
