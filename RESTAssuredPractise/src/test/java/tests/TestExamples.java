package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime()); //time in milliseconds
		System.out.println(response.getBody().asString()); //prints body of response as string
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode =  response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200); //checks the assertion
		
		}
	
	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",equalTo(8)).
			log().all();
		
	}
}
