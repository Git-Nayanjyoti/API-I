package request;

import client.RestClient;
import io.restassured.response.Response;

public class BestBuyRequestPlant {
	
	RestClient restClient;
	
	public BestBuyRequestPlant() {
		restClient = new RestClient();
	}
	
	public Response getAllProducts(){
		return restClient.SendGetRequest("/products");
	}
	
	public Response addProducts(String requestPayload){
		return restClient.SendPostRequest("/products", requestPayload);
	}
	
	public Response updateProducts(String requesrPayload){
		return restClient.SendPutRequest("/products", requesrPayload);
	}

}
