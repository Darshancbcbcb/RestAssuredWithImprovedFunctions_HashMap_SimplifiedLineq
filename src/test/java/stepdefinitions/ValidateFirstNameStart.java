package stepdefinitions;

import UtilitiesJava.UserUtils;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ValidateFirstNameStart {

    List<String> firstNames = new ArrayList<>();

    @Then("Validate the {string} to get the hundread users having the first name starts with {string} {int}")
    public void validateTheToGetTheHundreadUsersHavingTheFirstNameStartsWith(String Url, String firstAlpha, int lengthFirstName) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(Url);

        for (int i = 0; i < lengthFirstName; i++)
        {
            String actualCountry = res.jsonPath().get("results[" + i +"].name.first");
            firstNames.add(actualCountry);
        }

        //Act
        List<String> listOfFirstNames = UserUtils.sortNamesStartingWith(firstNames,firstAlpha);

        for (String firstName : listOfFirstNames) {
           System.out.println(firstName);
        }
    }
}
