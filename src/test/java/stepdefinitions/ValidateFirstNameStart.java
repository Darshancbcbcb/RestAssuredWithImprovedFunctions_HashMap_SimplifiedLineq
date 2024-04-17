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
    List<String> firstNameFiltered = new ArrayList<>();
    private String firstName;




    @Then("Validate the {string} to get the hundread users having the first name starts with {string}")
    public void validateTheToGetTheHundreadUsersHavingTheFirstNameStartsWith(String Url, String firstAlpha) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(Url);

        //Act
        List<String> listOfFirstNames = UserUtils.appendFirstName(firstAlpha, res);

        listOfFirstNames.sort(String::compareToIgnoreCase);

        for (String firstName : listOfFirstNames) {
           System.out.println(firstName);
        }
    }
}
