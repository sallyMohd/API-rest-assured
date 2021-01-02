import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class TestGet {


	@Test
	void test_01() 
	{
		//given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();
		Response resp = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);


	}
	@Test
	void test_02() 
	{
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
		String body = response.asString();
		System.out.println("Data"+ body);
	}

	@Test
	void test_03()
	{
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com/posts";
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam("id", "10").get();

		String jsonString = response.asString();
		System.out.println(response.getStatusCode()); 
		System.out.println("the items is: "+jsonString);
		Assert.assertEquals(jsonString.contains("optio molestias"), true);
	}
	



}






