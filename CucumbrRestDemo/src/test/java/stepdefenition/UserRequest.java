package stepdefenition;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRequest {

	@Given("user is on the correct page with list of users")
	public void user_is_on_the_correct_api_page() {
	   given().relaxedHTTPSValidation().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();		

	}

	@When("user able to add new user details")
	public void user_enter_the_details() {
		
		System.out.println("___User is adding new user___");
		
		JSONObject data=new JSONObject();
		data.put("name", "mika");
		data.put("job", "Test manager");
		String datastring = data.toJSONString();
		given()
		  .relaxedHTTPSValidation()
		  .body(datastring).post("https://reqres.in/api/users")
		  .then().statusCode(201).log().all();
	}

	@Then("validate the new user created")
	public void validate_the_new_user_created() {

		RequestSpecification request=given();
		Response response = request.relaxedHTTPSValidation().get("https://reqres.in/api/users");
        request.log().all();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(),200 );
		
		
		
	}
		
}
