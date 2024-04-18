Feature: Validate the GET operation for more number of users

  Background: Validate the GET request will return success
    Given User will perform the GET operation "https://randomuser.me/"
    When Status code should be 200

  @XRAY-5678 @REST @GET
  Scenario: Verify the age of a User greater than 40
    Then Validate the User age greater than 40

  @XRAY-7896 @REST @GET
  Scenario: Verify whether the user comes from US
    Then Validate the User comes from "United States"

  @XRAY-4356 @REST @GET
  Scenario: Verify the password of the user has no special character
    Then Validate the password does not contain special charater "^[a-zA-Z0-9]+$"

  @XRAY-7865 @REST @GET
  Scenario: Verify the password of the user has a special character
    Then Validate the password for "https://randomuser.me/api/?password=special,upper,lower,1-16" that contain special charater "^[a-zA-Z0-9!@#$%^&*()-_=+\\\\;:'\",.<>/?`~\\[\\]{}]+$"