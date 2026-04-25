Feature: User login to the site

  @Smoke
  Scenario: User login to the site using valid credentails
    Given User is on login page
    When User enters valid username and password and logged in
    Then User should redirect to the homepage as logged in
	@outline
  Scenario Outline: User login to the site with multipe times
    Given User is on login page
    When User enters username "<UN>" and password "<PW>" and logged in
    Then User should redirect to the homepage as logged in

    Examples:
      | UN          | PW        |
      | aruntest24  | Test@1234 |
      | aruntest24a | Test@1234 |
