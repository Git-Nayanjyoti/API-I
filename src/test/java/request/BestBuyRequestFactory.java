package request;

import client.RestClient;
import io.restassured.response.Response;

public class BestBuyRequestFactory {
	
	RestClient restClient;
	
	public BestBuyRequestFactory() {
		restClient = new RestClient();
	}
	
	public Response getAllProducts(String str,String query, int limit){
		if(query == null) {
			return restClient.SendGetRequest(str);
		} else {
			return restClient.SendGetRequest(str,query,limit);
		}	
	}
	
	public Response addProducts(String requestPayload){
		return restClient.SendPostRequest("/products", requestPayload);
	}
	
	public Response updateProducts(String requesrPayload){
		return restClient.SendPutRequest("/products", requesrPayload);
	}

}
