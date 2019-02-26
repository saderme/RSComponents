Feature: Search Scenarios for RS Components

 @search @regression @positive
  Scenario Outline: Search without Filters
    Given launch browser '<browserName>'
    And user navigates to the URL 'http://uk.rs-online.com/web/'
    When user clicks on '<option1>' menu
    And user clicks on '<option2>' submenu
    And user clicks on '<option3>' product category
    And user clicks on '<option4>' product category
    Then product count should be '<prodcount>'


    Examples: 
      | browserName | option1       | option2    |option3             |option4       |prodcount|
      | chrome      | All Products  | Connectors |Circular Connectors |DIN Connectors|873      |


 @search @negative
  Scenario Outline: Search without Filters
    Given launch browser '<browserName>'
    And user navigates to the URL 'http://uk.rs-online.com/web/'
    When user clicks on '<option1>' menu
    And user clicks on '<option2>' submenu
    And user clicks on '<option3>' product category
    And user clicks on '<option4>' product category
    Then product count should be '<prodcount>'


    Examples: 
      | browserName | option1       | option2    |option3             |option4       |prodcount|
      | chrome      | All Products  | Connectors |Circular Connectors |DIN Connectors|300      |

 @search @positive @filter
  Scenario Outline: Search WITH Filters
    Given launch browser '<browserName>'
    And user navigates to the URL 'http://uk.rs-online.com/web/'
    When user clicks on '<option1>' menu
    And user clicks on '<option2>' submenu
    And user clicks on '<option3>' product category
    And user clicks on '<option4>' product category
    And user filters on '<filterOption>', selecting '<filterValue>'
    Then product count should be '<prodcount>'


    Examples: 
      | browserName | option1       | option2    |option3             |option4       |filterOption | filterValue       | prodcount|
      | chrome      | All Products  | Connectors |Circular Connectors |DIN Connectors|Mounting Type| Chassis Mount     | 31       |

      
  @search @negative @filter
  Scenario Outline: Search WITH Filters
    Given launch browser '<browserName>'
    And user navigates to the URL 'http://uk.rs-online.com/web/'
    When user clicks on '<option1>' menu
    And user clicks on '<option2>' submenu
    And user clicks on '<option3>' product category
    And user clicks on '<option4>' product category
    And user filters on '<filterOption>', selecting '<filterValue>'
    Then product count should be '<prodcount>'


    Examples: 
      | browserName | option1       | option2    |option3             |option4       |filterOption | filterValue       | prodcount|
      | chrome      | All Products  | Connectors |Circular Connectors |DIN Connectors|Mounting Type| Chassis Mount     | 30       |