package UtilitiesJava;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

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

    public static List<String> sortNamesStartingWith(List<String> names, String desiredChar) {
        char charValue = desiredChar.charAt(0);

        // Create a HashMap to store names starting with the desired character
        HashMap<String, String> nameMap = new HashMap<>();

        // Filter names that start with the desired character and add them to the HashMap
        for (String name : names) {
            if (name != null && !name.isEmpty() && name.toLowerCase().charAt(0) == Character.toLowerCase(charValue)) {
                nameMap.put(name, name);
            }
        }

        // Sort the names alphabetically
        List<String> sortedNames = new ArrayList<>(nameMap.keySet());
        Collections.sort(sortedNames);

        // Return the sorted names
        return sortedNames;
    }

    public static boolean isValidPassKeyForThatRespectiveBasePath(String Url, String expectedPasswordRegex) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(Url);

        //Act
        String actualPassword = res.jsonPath().get("results[0].login.password");

        System.out.println("Password of the random request is :" + actualPassword);

        boolean isValid = UserUtils.isValidPassword(expectedPasswordRegex, actualPassword);
        return isValid;
    }

    public static int getActualAge() {
        Response res = given().contentType(ContentType.JSON).when().get("https://randomuser.me/api");

        int actualAge = res.jsonPath().get("results[0].dob.age");

        System.out.println("Age of the user request is more than 40 hence test passed : " + actualAge);

        return actualAge;
    }

    public static String getActualCountry() {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get("https://randomuser.me/api");

        //Act
        String actualCountry = res.jsonPath().get("results[0].location.country");

        System.out.println("Country of the user request is : " + actualCountry);

        return actualCountry;
    }

    public static boolean isValidPassKey(String url, String expectedPasswordRegex) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(url);

        //Act
        String actualPassword = res.jsonPath().get("results[0].login.password");

        System.out.println("Password of the random request is :" + actualPassword);

        boolean isValid = UserUtils.isValidPassword(expectedPasswordRegex, actualPassword);
        return isValid;
    }

    public static boolean isValidPassKeyWithOutSpecialCharater(String Url, String expectedPasswordRegex) {
        //Arrange
        Response res = given().contentType(ContentType.JSON).when().get(Url);

        //Act
        String actualPassword = res.jsonPath().get("results[0].login.password");

        System.out.println("Password of the random request is :" + actualPassword);

        boolean isValid = UserUtils.isValidPassword(expectedPasswordRegex, actualPassword);
        return isValid;
    }
    // Other utility methods for managing user data can go here
}
