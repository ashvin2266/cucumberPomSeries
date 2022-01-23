@contact
Feature: verify the contact us feature
  @smoke
  Scenario Outline: : verify user contact us successfully
    Given  user are on landing page
    When user click on contact us link
    Then user are on the contact us page
    And user verify user are on contact us page title as "Contact us - My Store"
    When user fill the contact us form with valid detail from excell sheetname "<SheetName>" and rownumber <RowNumber>
    And user click on send button
    Then it shows a successful message "Your message has been successfully sent to our team."
    Examples:
    |SheetName|RowNumber|
    |Contact us|0        |
    |Contact us|1        |
    |Contact us|2       |
    |Contact us|3        |