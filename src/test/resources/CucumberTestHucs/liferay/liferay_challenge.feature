Feature: LifeRay Challenge
  This is an instrumentation of automated test for liferay challenge

  Scenario: This form have a cool title Let's party rock.
    When this form to get open
    Then shows this text "Let's party rock."

  Scenario: All fields are mandatory
    Given this form is open
    When the form is submitted
    Then will show this message "This field is required."

