package stepdefinitions;

import UtilitiesJava.UserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Objects;

public class ValidateUserComesFromUS {

    @Then("Validate the User comes from {string}")
    public void validateTheUserComesFromUS(String expectedCountry) {
        String actualCountry = UserUtils.getActualCountry();

        //Assert
        if (!Objects.equals(actualCountry, expectedCountry)) {
            Assert.fail("User is not from United States" + expectedCountry + " test failed " + actualCountry);
        }

        Assert.assertTrue("User is from correct " + expectedCountry, true);
        System.out.println("User is from :" + expectedCountry);
    }
}
