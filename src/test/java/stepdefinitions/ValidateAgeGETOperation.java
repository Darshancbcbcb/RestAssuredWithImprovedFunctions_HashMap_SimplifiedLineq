package stepdefinitions;

import UtilitiesJava.UserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ValidateAgeGETOperation {

    @Given("User perform the GET operation {string}")
    public void userPerformTheGETOperation(String url) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(url);
    }

    @When("Status code {int}")
    public void statusCode(int statusCode) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://randomuser.me/")
                .then()
                .statusCode(statusCode);

    }

   @Then("Validate the User age greater than {int}")
    public void validateTheUserAgeGreaterThan(int expectedAge) {
       int actualAge = UserUtils.getActualAge();

       if (actualAge > expectedAge) {
           Assert.fail("User age is lesser than expected age" + expectedAge + " test failed " + actualAge);
       }

       Assert.assertTrue("Test passed as the age is greater than " + expectedAge ,actualAge > expectedAge);
       System.out.println("Age of the user request is more than 40 hence test passed : " + actualAge);
    }
}
