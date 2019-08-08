package com.qa.test;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {
	
	
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	
	@BeforeMethod
	public void setup() {
		testBase=new TestBase();
		String serviceUrl=prop.getProperty("URL");
		String apiUrl=prop.getProperty("serviceURL");
		
		url=serviceUrl+apiUrl;
		System.out.println(url);
		
	}
		
		@Test
		public void getAPITest() throws ClientProtocolException, IOException
		{
			restClient=new RestClient();
			closeableHttpResponse=restClient.get(url);}
		
		//Get the Status Code
				int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
				System.out.println("Status code" + statusCode);
				Assert.assertEquals(statusCode,200,"Stats code is not 200");
				
							
		        //Converting to JSON format
				String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
				// Getting body of JSOn
				JSONObject responseJson = new JSONObject(responseString);
				System.out.println("Response JSON from API" + responseJson);
				
				// Getting all headers
				Header[] headerArray = closeableHttpResponse.getAllHeaders();
				HashMap<String, String> allHeaders = new HashMap<String, String>();
				for (Header header : headerArray) {
					allHeaders.put(header.getName(), header.getValue());
				}

				System.out.println("Header Array-->" + allHeaders);
	}


