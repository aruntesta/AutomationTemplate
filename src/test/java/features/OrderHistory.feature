Feature: User navigates to the order hsitory

  Scenario: User navigate to the order history page and validates the page heading
    Given User is on login page
    When User enters valid username and password and logged in
    And User clicks the check your order link in the header
    Then User validates the page heading


  Scenario: User search the product
    Given User is on login page
    When User enters valid username and password and logged in
    And User clicks the check your order link in the header
    Then User search for the product category "test"
