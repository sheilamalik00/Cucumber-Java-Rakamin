Feature: Log in to the saucedemo web

  @Regression @Positive
  Scenario: Log in to the saucedemo web with valid data
    Given user launch the website app in  www.saucedemo.com
    When user input a registered username
    And user input a registered password
    And user click log in button
    Then home page should be displayed

  @Regression @Negative
  Scenario: Log in to the saucedemo web with invalid data
    Given user open the website app in  www.saucedemo.com
    When user input an unregistered username
    And user input an unregistered password
    And user tap log in button
    Then user get error message