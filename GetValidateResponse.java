package ResponseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;




public class GetValidateResponse {
	
  @Test
  public void getValidation() {
	  
		/*
		 * given(). when(). get("http://ergast.com/api/f1/2005/circuits.json"). then().
		 * assertThat(). statusCode(200). and().
		 * body("MRData.CircuitTable.Circuits",hasSize(19)).
		 * 
		 * and(). header("contect-length",equalTo("4356"));
		 */
	  	  	  
	  Response response=RestAssured.get("https://reqres.in/api/users");
	  int resCode=response.getStatusCode();
	  Assert.assertEquals(resCode, 200);
	  
	   
	  String responseBody=response.asString();
	  Headers header=response.getHeaders();
	  System.out.println("Response data is :" +responseBody);
	  System.out.println("Response header is:"+ header);
	  
  }
}
