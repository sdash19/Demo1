package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestClient {
	
	String url="https://reqres.in/api/users";
@Test
	
	//Performing  GET
	public void gets(String url) throws ClientProtocolException, IOException {
	  
		CloseableHttpClient httpClient = HttpClients.createDefault();//creates connection
		HttpGet httpget = new HttpGet(url);/// httpget is the request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
		
		//verify status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code" + statusCode);
		Assert.assertEquals(statusCode,200,"Stats code is not 200");
		
		//Verify the content of Response
		
		String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson=new JSONObject(responseString);//Response body
		System.out.println("The response body :"+ responseJson);
		//Get the header
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}

		System.out.println("All headers :" + allHeaders);
}
		
		
	
		//Performing POST
	@Test
	public void posts(String url) throws ClientProtocolException, IOException
	{

		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);//http post request
		//  payload
		JSONObject json=new JSONObject();
		json.put("id","345");
		  json.put("email","abc@reqres.in");
		  json.put("first_name","test1");
		  json.put("last_name","test2");
		  json.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
		StringEntity entityString=new StringEntity(json.toString());
		httpPost.setEntity(entityString);
		
		// add Header
		
			httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		
		
		CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpPost);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code" + statusCode);
		Assert.assertEquals(statusCode,201,"Stats code is not 201");
	}
	
	//Performing PUT
	@Test
	public void puts(String url) throws ClientProtocolException, IOException {
	
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPut httpPut=new HttpPut(url);//http put request
		// update Payload
		JSONObject json=new JSONObject();
		json.put("id","80");
		  json.put("email","abc@reqres.in");
		  json.put("first_name","test1");
		  json.put("last_name","test2");
		  json.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
		StringEntity entityString=new StringEntity(json.toString());
		httpPut.setEntity(entityString);//payload
		
				
		CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpPut);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code" + statusCode);
		Assert.assertEquals(statusCode,200,"Stats code is not 200");
		}
	
	//Performing DELETE
	@Test
	public void deletes(String url) throws ClientProtocolException, IOException {
		String uRL="https://reqres.in/api/users/20";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpdelete = new HttpDelete(uRL);/// http delete request
						
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpdelete);
		
		//verify status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code" + statusCode);
		Assert.assertEquals(statusCode,204,"Stats code is not 204");
		
	}
	}



