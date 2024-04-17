package UtilitiesJava;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserUtils {


        public static boolean isValidPassword(String passwordRegex, String password) {
            // Regular expression to match only letters and numbers (no special characters)
            String regex = passwordRegex;

            // Compile the regex pattern
            Pattern pattern = Pattern.compile(regex);

            // Check if the password matches the pattern
            return pattern.matcher(password).find();
        }

    public static List<String> appendFirstName(String firstAlpha, Response res) {
        List<String> firstNames = new ArrayList<>();
        List<String> firstNameFiltered = new ArrayList<>();

        int[] items = new int[100];
        for (int i = 0; i < items.length; i++)
        {
            String actualCountry = res.jsonPath().get("results[" + i +"].name.first");
            firstNames.add(actualCountry);
        }

        for (String firstName : firstNames) {
            if (firstName.startsWith(firstAlpha)) {
                // Extract the numeric value from the string and add to sum
                firstNameFiltered.add(firstName);
            }
        }

        return firstNameFiltered;
    }

    // Other utility methods for managing user data can go here
}
