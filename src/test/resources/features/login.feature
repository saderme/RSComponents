Feature: Login to RS Components

 @login @regression @positive
  Scenario Outline: Successful login 
    Given launch browser '<browserName>'
    When user navigates to the URL 'http://uk.rs-online.com/web/'
    And user click on login
    And user logs in with valid credentials '<userName>' and '<password>'
    Then user is successfully logged in

    Examples: 
      | browserName | userName | password   |
      | chrome      | saderme  | Welcome123 |

@login @regression @negative
  Scenario Outline: Unsuccessful login
    Given launch browser '<browserName>'
    When user navigates to the URL 'http://uk.rs-online.com/web/'
    And user click on login
    And  user logs in with invalid credentials '<userName>' and '<password>'
    Then error message '<invalidcredentials>' is displayed

    Examples: 
      | browserName | userName   | password   |invalidcredentials                      |
      | chrome      | saderme12  | InvalidPwd |Your Username and/or Password is invalid|
