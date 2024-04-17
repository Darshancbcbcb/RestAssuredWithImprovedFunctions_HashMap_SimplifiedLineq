package stepdefinitions;

import UtilitiesJava.UserUtils;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ValidatePasswordGETOperation {

    @Then("Validate the password does not contain special charater {string}")
    public void validateThePasswordDoesNotContainSpecialCharater(String expectedPasswordRegex) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get("https://randomuser.me/api");

        //Act
        String actualPassword = res.jsonPath().get("results[0].login.password");
        System.out.println("Password of the random request is :" + actualPassword);
        boolean isValid = UserUtils.isValidPassword(expectedPasswordRegex, actualPassword);

        //Assert
        Assert.assertTrue("Password does not contain special charater", isValid);
    }

    @Then("Validate the password for {string} does not contain special charater {string}")
    public void validateThePasswordDoesNotContainSpecialCharater(String Url, String expectedPasswordRegex) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(Url);

        //Act
        String actualPassword = res.jsonPath().get("results[0].login.password");
        System.out.println("Password of the random request is :" + actualPassword);
        boolean isValid = UserUtils.isValidPassword(expectedPasswordRegex, actualPassword);

        //Assert
        if(isValid)
        {
            Assert.assertTrue("Password does not contain special charater", isValid);
        }
        else
        {
            Assert.fail("Password contain special charater");
        }
    }
}
