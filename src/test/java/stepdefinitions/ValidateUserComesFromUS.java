package stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ValidateUserComesFromUS {

    @Then("Validate the User comes from {string}")
    public void validateTheUserComesFromUS(String expectedCountry) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get("https://randomuser.me/api");

        //Act
        String actualCountry = res.jsonPath().get("results[0].location.country");

        //Assert
        if (!Objects.equals(actualCountry, expectedCountry)) {
            Assert.fail("User is not from United States" + expectedCountry + " test failed " + actualCountry);
        }

        Assert.assertTrue("User is from correct " + expectedCountry, true);
        System.out.println("User is from :" + expectedCountry);


    }
}
