@triSoft
Feature: Verify the total link present on Home Page
  and find any broken link present on Home Page
  Scenario: Verify the total link present on Home Page
    Given User are on Home Page
    When User find the all link present on Home Page
    Then User verify the title of the Home Page is "Healthcare Tech Company | Based in Nottingham | Trisoft"
    And User verify the total link present on Home Page is 50