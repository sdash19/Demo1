package ResponseTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutValidateResponse {
  @Test
  
  public void putValidation() {
	  
	  RequestSpecification request=RestAssured.given();
	  request.header("Content-Type", "application/json; charset=utf-8");
	  JSONObject json=new JSONObject();
	  json.put("id","12");
	  json.put("email","george.bluth@reqres.in");
	  json.put("first_name","FName1");
	  json.put("last_name","LName2");
	  json.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
	  
	  request.body(json.toJSONString());
	  
	  Response response=request.put("https://reqres.in/api/users?id=12");
	  int resCode=response.getStatusCode();
	  Assert.assertEquals(resCode, 200);
	  
	  
  }
}
