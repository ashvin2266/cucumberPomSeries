Feature: verify the contact feature
  @angel
  Scenario: user successfully send contact form
    Given user are on HomePage
    When User click on contact link
    Then User verify the url of contact pageas as "https://www.angelsolutions.co.uk/contactus/"
    And User verify the companey logo is displayed on contact page
    And User verify the title of the contact page is "Contact Us | Angel Solutions Ltd"
    When User select a subject is a "Recruitment Enquiry"
    Given User enter the name as "Abc"and email address as "abc@hotmail.com"
    And User enter phone as "01234568792"
    And User select the product query is as "Balance"
    And User enter his job title as "Manager"
    And user enter the message as "I need information about balance"
    When User click on submit button
    Then User see the thank you message as "THANK YOU, YOUR MESSAGE WAS SUBMITTED SUCCESSFULLY."
