Feature: verify the careers feature
  @optima
  Scenario: search a clinical vacancy available  in london
    Given User are on HomePage
    When user click on careers link
    Then user are on careers page contains url as "https://www.optimahealth.co.uk/careers/"
    And user verify the company logo is displayed on career page
    Given user select a job categories from dropdown as "Clinical" in search bar
    And user select a type of job is "Types - All"
    And user select a location is "London"
    When user click on filter button
    Then user should see the job available in london is displayed in page
    And user verify the total available job is 15
    And user print the all job title