package com.request;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TC001_Get_All_Users {

	@Test
	public void getAllUsers() {
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("data.id[2]", equalTo(9))
		.body("data.first_name[0]", equalTo("Michael"))
		.and()
		.header("Content-Type", equalTo("application/json; charset=utf-8"))
		.header("Content-Encoding", equalTo("gzip"))
		.log()
		.all();
	}
}
