package stepdefinitions;

import UtilitiesJava.UserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ValidatePasswordGETOperation {

    @Then("Validate the password does not contain special charater {string}")
    public void validateThePasswordDoesNotContainSpecialCharater(String expectedPasswordRegex) {
        boolean isValid = UserUtils.isValidPassKey("https://randomuser.me/api", expectedPasswordRegex);

        //Assert
        Assert.assertTrue("Password does not contain special charater", isValid);
    }

    @Then("Validate the password for {string} does not contain special charater {string}")
    public void validateThePasswordDoesNotContainSpecialCharater(String Url, String expectedPasswordRegex) {
        boolean isValid = UserUtils.isValidPassKeyWithOutSpecialCharater(Url, expectedPasswordRegex);

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
