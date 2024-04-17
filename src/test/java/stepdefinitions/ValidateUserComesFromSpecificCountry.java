package stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ValidateUserComesFromSpecificCountry {

    @Then("Validate the User for specific {string} country {string}")
    public void validateTheUserForSpecificCountry(String Url, String expectedCountry) {

        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(Url);

        //Act
        String actualCountry = res.jsonPath().get("results[0].location.country");


        //Assert
        Assert.assertEquals("Country does not match", expectedCountry, actualCountry);

    }
}
