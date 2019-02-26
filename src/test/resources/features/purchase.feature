Feature: Search Scenarios for RS Components

 @purchase @end2end
  Scenario Outline: Search and Add to Basket
    Given launch browser '<browserName>'
    And user navigates to the URL 'http://uk.rs-online.com/web/'
    And user click on login
    And user logs in with valid credentials '<userName>' and '<password>'
    And user is successfully logged in
    And the user searches for '<searchval>' 
   When the product page for '<searchval>' is displayed
   And the user clicks Add to Basket
   And the user clicks View Basket
 #   Then Basket is displayed containing '<searchval'>

    Examples: 
      | browserName | userName | password   |searchval | 
      | chrome      | saderme  | Welcome123 |631-9215  | 

