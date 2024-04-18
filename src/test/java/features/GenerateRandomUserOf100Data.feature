Feature: Generate the random user of 100 data and sort according to the FirstName

  @XRAY-7896 @REST @GET
  Scenario Outline: Validate all the conditions where firstname should be sorted alphabetically
    Given User perform the GET operation <URL>
    When Status code <StatusCode>
    Then Validate the <URL> to get the hundread users having the first name starts with <Alpha> <firstNameLength>

    Examples:
      | URL                                      | StatusCode | Alpha | firstNameLength |
      | "https://randomuser.me/api/?results=100" | 200        | 'A'   | 100             |
      | "https://randomuser.me/api/?results=100" | 200        | 'S'   | 150             |
      | "https://randomuser.me/api/?results=100" | 200        | 'F'   | 100             |
      | "https://randomuser.me/api/?results=100" | 200        | 'G'   | 50              |

