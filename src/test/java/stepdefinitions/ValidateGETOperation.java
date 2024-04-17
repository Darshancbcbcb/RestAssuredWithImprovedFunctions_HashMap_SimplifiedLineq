package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


public class ValidateGETOperation {


    @Given("User will perform the GET operation {string}")
    public void userWillPerformTheGETOperation(String url) throws Throwable {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }

    @When("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) throws Throwable {

        given().contentType(ContentType.JSON).when().get("https://randomuser.me/api").then().log().all();
    }
}




