Feature: Validate multiple condition statements for each of the user

  @XRAY-7896 @REST @GET
  Scenario Outline: Validate all the conditions with examples to ensure positive and negative criteria
    Given User perform the GET operation <URL>
    When Status code <StatusCode>
    Then Validate the User age greater than <age>
    Then Validate the User for specific <URL> country "United States"
    Then Validate the password for <URL> does not contain special charater <password>
    Then Validate the password for <URL> that contain special charater <password>

    Examples:
      | URL                                                            | StatusCode | password                                                | age |
      | "https://randomuser.me/api/?nat=us"                            | 200        | "^[a-zA-Z0-9]+$"                                        | 40  |
      | "https://randomuser.me/api/?nat=us"                            | 200        | "^[a-zA-Z0-9]+$"                                        | 39  |
      | "https://randomuser.me/api/?nat=us"                            | 200        | "^[!@#$%^&*()-_=+\\\\;:'\",.<>/?`~\\[\\]{}]+$"          | 40  |
      | "https://randomuser.me/api/?nat=us"                            | 400        | "^[a-zA-Z0-9]+$"                                        | 40  |
      | "https://randomuser.me/api/?nat="                              | 200        | "^[a-zA-Z0-9]+$"                                        | 40  |
      | "https://randomuser.me/api/?password=special,upper,lower,1-16" | 200        | "^[a-zA-Z0-9!@#$%^&*()-_=+\\\\;:'\",.<>/?`~\\[\\]{}]+$" | 40  |

