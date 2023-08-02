package stepdefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Util;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceSteps extends Util {

	RequestSpecification req;
	Response rep;

	@Given("create payload with request")
	public void create_payload_with_request() throws IOException {

		TestDataBuild b = new TestDataBuild();

		req = given().spec(setup()).body(b.requestData());

	}

	@When("user send {string} request with {string} method")
	public void user_send_request_with_method(String endpoint, String method) {
		APIResources resources = APIResources.valueOf(endpoint);
		System.out.println(resources.getResource());

		if (method.equalsIgnoreCase("Post")) {

			rep = req.when().post(resources.getResource());
		} else if (method.equalsIgnoreCase("get")) {
			rep = req.when().get(resources.getResource());
		} else if (method.equalsIgnoreCase("put")) {
			rep = req.when().put(resources.getResource());
		} else if (method.equalsIgnoreCase("delete")) {
			rep = req.when().delete(resources.getResource());
		}
	}

	@Then("validate status code is {int}")
	public void validate_status_code_is(Integer int1) {

		rep.then();
		int statusCode = rep.statusCode();
		assertEquals(200, statusCode);

	}

	@Then("{string} value in body is {string}")
	public void value_in_body_is(String expectedKey, String expectedValue) {
		String response = rep.asString();
		String actualValue = getJsonValue(response, expectedKey);
		assertEquals(expectedValue, actualValue);
	}
}