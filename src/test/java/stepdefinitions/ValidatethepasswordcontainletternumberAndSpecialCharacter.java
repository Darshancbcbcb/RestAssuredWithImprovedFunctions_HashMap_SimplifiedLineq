package stepdefinitions;

import UtilitiesJava.UserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ValidatethepasswordcontainletternumberAndSpecialCharacter {
    @Then("Validate the password for {string} that contain special charater {string}")
    public void validateThePasswordForThatContainSpecialCharater(String Url, String expectedPasswordRegex) {

        boolean isValid = UserUtils.isValidPassKeyForThatRespectiveBasePath(Url, expectedPasswordRegex);

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
