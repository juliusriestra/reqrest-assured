package com.request;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TC002_Get_ById_User {

	@Test
	public void getUserById() {
		given()
		.when().get("https://reqres.in/api/users/2")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("data.id", equalTo(2))
		.body("data.first_name", equalTo("Janet"))
		.and()
		.header("Content-Type", equalTo("application/json; charset=utf-8"))
		.header("Cache-Control", equalTo("max-age=14400"))
		.log()
		.all();
		
	}
}
