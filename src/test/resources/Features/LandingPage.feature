@login
Feature: verify landing page features
  @smoke
  Scenario: verify the url of landing page and logo is displayed
    Given  user are on landing page
    Then user are on landing page contains url as "http://automationpractice.com/index.php"
    And  user verify the title of the page is as "My Store"
    And user verify the logo of the company is displayed
    Then user verify the signIn button is Enabled

  Scenario: identify total link present on the landing page
    Given  user are on landing page
    Then user identified total link present on page
    And user print all link on console page