package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


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

	
	//Performing  GET
	public void get(String url) throws ClientProtocolException, IOException {
		 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);/// httpget is the request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
		
		//verify status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code" + statusCode);
		Assert.assertEquals(statusCode,200,"Stats code is not 200");
		
	}
		//Performing POST
	
	public void post(String url) throws ClientProtocolException, IOException
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
	
	public void put(String url) throws ClientProtocolException, IOException {
	
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
	
	public void delete(String url) throws ClientProtocolException, IOException {
		 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpdelete = new HttpDelete(url);/// http delete request
		JSONObject json=new JSONObject();
		json.accumulate("id","80");
		StringEntity entityString=new StringEntity(json.toString());
					
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpdelete);
		
		//verify status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code" + statusCode);
		Assert.assertEquals(statusCode,204,"Stats code is not 204");
		
	}
	}



