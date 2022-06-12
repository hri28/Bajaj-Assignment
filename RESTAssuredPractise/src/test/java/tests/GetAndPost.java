package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.HashMap;

public class GetAndPost {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given()
			.get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",equalTo("George")).
			body("data.first_name", hasItems("George","Lindsay","Michael")).
			body("data.last_name", hasItems("Edwards","Ferguson","Lawson"));
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void testPost() {
		
		//for POST requests, a header and body is created
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Hrishita");
//		map.put("job", "Engineer");
//		
//		System.out.println(map);
		
		JSONObject response = new JSONObject(); //simple json to encode data to json
		response.put("name", "Hrishita");
		response.put("email", "hrish@gmail.com");
		
		System.out.println(response);
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json"). //telling the server the data is of type JSON
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(response.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
		
		Assert.assertTrue(true);
	
	}
	
}
