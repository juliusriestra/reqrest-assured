package com.request;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojo.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
public class TC003_Post_New_User {

	@Test
	public void postNewUserPojo() {		
		User user = new User("julius", "leader");
		Response response = given()
		.contentType(ContentType.JSON)
		.body(user)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().body()
		.extract().response();
		String jsonString = response.asString();
		Assert.assertEquals(jsonString.contains("leader"), true);
	}
	
	@Test
	public void postNewUserJson() {
		Response response = given()
				.body(new File("./post.json"))
				.contentType(ContentType.JSON)
				.post("https://reqres.in/api/users")
				.then()
				.statusCode(201)
				.log().body()
				.extract().response();
		String responseJson = response.asString();
		Assert.assertEquals(responseJson.contains("automation"), true);
	}
}
