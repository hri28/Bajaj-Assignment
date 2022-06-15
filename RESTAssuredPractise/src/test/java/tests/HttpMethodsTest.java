package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutAndDelete {
	
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("name","Hrishita");
		request.put("email", "hrish_2@gmail.com");
		
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","applicatiohn/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).log().all();
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testDelete() {
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).log().all();
		
		Assert.assertTrue(true);
		
	}

}
