package com.request;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class TC005_Delete_ById_User {

	@Test
	public void deleteUserById() throws InterruptedException {
		Response response = given()
		.when().delete("https://reqres.in/api/users/2")
		.then()
		.assertThat()
		.statusCode(204)
		.log().body()
		.extract().response();
		Thread.sleep(3000);
//		String responseBody = response.getBody().asString();
		String responseBody = response.asString();
		Assert.assertTrue(responseBody.isEmpty());
		
	}
}
