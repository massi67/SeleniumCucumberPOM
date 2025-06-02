
Feature: Login Functionality

	@Login @Regression
  Scenario Outline: Login with credential "<username>" | "<password>"
    Given user is on the login page
    When user enters valid "<username>" and "<password>"
    Then user should be redirected to the dashboard
    Examples:
    	|username        | password     |
    	|standard_user   | secret_sauce |
    	|standard_user   | secret_sauce |
    	|locked_out_user | secret_sauce |
    	|problem_user    | secret_sauce |