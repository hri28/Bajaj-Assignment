package tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class HttpMethodsTest {

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
		
		
		baseURI = "https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).log().all();
		
		Assert.assertTrue(true);
		
	}

}
