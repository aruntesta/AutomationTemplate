Feature: User login to the site

  @Smoke
  Scenario: User login to the site using valid credentails
    Given User is on login page
    When User enters valid username "aruntest24" and password "Test@1234" and logged in
    Then User should redirect to the homepage as logged in
