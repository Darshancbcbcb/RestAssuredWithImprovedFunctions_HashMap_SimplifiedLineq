Feature: Generate the random user of 100 data and sort according to the FirstName

  @XRAY-7896 @REST @GET
  Scenario Outline: Validate all the conditions where firstname should be sorted alphabetically
    Given User perform the GET operation <URL>
    When Status code <StatusCode>
    Then Validate the <URL> to get the hundread users having the first name starts with <Alpha>

    Examples:
      | URL                                      | StatusCode | Alpha |  |
      | "https://randomuser.me/api/?results=100" | 200        | "A"   |  |
      | "https://randomuser.me/api/?results=100" | 200        | "S"   |  |
      | "https://randomuser.me/api/?results=100" | 200        | "F"   |  |
      | "https://randomuser.me/api/?results=100" | 200        | "G"   |  |

