@create
Feature: create an new account
  @smoke
  Scenario Outline: user are able to create new account by entering valid details
    Given user are on landing page
    When user click on sign In button
    And user enter a valid email on create an account page
    And user click on create an account
    Then user see the create an account page heading  as "CREATE AN ACCOUNT"
    When  user fill up all personal information from excel sheetname as "<createAccount>" and row number as <Rawnumber>
    And user click on register  button
    Then user should be on his account Page
    And user verify account page by heading as "MY ACCOUNT" present on page
    And user verify the account page title as "My account - My Store"
    And  user verify the welcome text contains"Welcome to your account"
    Examples:
    |createAccount|Rawnumber|
    |createAccount|0        |
    |createAccount|1       |