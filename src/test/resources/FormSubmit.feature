Feature: Form Automation
  As a user
  I want to fill my form also I submit it
  So that form successfully submitted

  Scenario Outline: Fill all fields and submit form
    Given user navigates to the app url
    When user fills first name with name "<firstName>"
    And user fills last name with last name "<lastName>"
    And user fills gender
    And user fills date of birth "<DOB>"
    And user fills address
    And user fills email address "<email>"
    And user fills password "<password>"
    And user fills company name
    And user select Role - QA
    And User select job expectation: Good teamwork, High salary, Challenging
    And User select random three options from ways of development
    And user fill comment
    And user click submit button
    Then form is submitted

    Examples:
      |firstName|lastName|DOB       |email          |password|
      |Olga     |Ivanova |02/01/1980|test1@gmail.com|123QAZ  |
      |Petr     |Snigerev|01/17/2006|test2@gmail.com|456QAZ  |
      |Anna     |Drozd   |09/09/2009|test3@gmail.com|789QAZ  |
