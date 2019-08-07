package ResponseTest;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostValidateResponse {
  @Test
  public void postValidation() {
	  
	  RequestSpecification request=RestAssured.given();
	  request.header("Content-Type", "application/json; charset=utf-8");
	  JSONObject json=new JSONObject();
	  json.put("id","4");
	  json.put("email","george.bluth@reqres.in");
	  json.put("first_name","Geo");
	  json.put("last_name","Bluehttps://reqres.in/api/users");
	  json.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
	  
	  request.body(json.toJSONString());
	  
	  Response response=request.post("https://reqres.in/api/users");
	  int resCode=response.getStatusCode();
	  Assert.assertEquals(resCode, 201);
	  
	  
  }
}
