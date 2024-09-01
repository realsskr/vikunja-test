@test
Feature: New user registration

  Scenario: Register new user with invalid test data
	Given user is on vikunja page
	And user clicks on create account link
	Then user should be navigated to registration page
	When user enters "te" "test123@test.com" and "123test"
	And user clicks on create account button
	Then user should be presented with "Invalid Data" error message
