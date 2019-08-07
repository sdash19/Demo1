package ResponseTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteValidateResponse {
	 @Test
	  public void deleteValidation() {
		  
		  RequestSpecification request=RestAssured.given();
		  
		  JSONObject json=new JSONObject();
		  request.body(json.toJSONString());
		  
		  Response response=request.delete("https://reqres.in/api/users?id=11");
		  int resCode=response.getStatusCode();
		  Assert.assertEquals(resCode, 204);
		  
		  
	  }
	}