package com.request;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojo.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class TC004_Put_New_User {

	@Test
	public void putNewUserPojo() {		
		User user = new User("julius", "quality");
		given()
		.contentType(ContentType.JSON)
		.body(user)
		.when().put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().body()
		.body("name", equalTo("julius"))
		.body("job", equalTo("quality"));
	}
	
	@Test
	public void putNewUserJson() {
		Response response = given()
				.body(new File("./post.json"))
				.contentType(ContentType.JSON)
				.put("https://reqres.in/api/users/3")
				.then()
				.statusCode(200)
				.log().body()
				.extract().response();
		String responseJson = response.asString();
		Assert.assertEquals(responseJson.contains("automation"), true);
	}
}
