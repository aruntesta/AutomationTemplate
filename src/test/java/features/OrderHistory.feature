Feature: 
User navigates to the order hsitory

Scenario:
User navigate to the order history page and validates the page heading

Given User is on login page
When User enters valid username "aruntest24" and password "Test@1234" and logged in
And User clicks the check your order link in the header
Then User validates the page heading