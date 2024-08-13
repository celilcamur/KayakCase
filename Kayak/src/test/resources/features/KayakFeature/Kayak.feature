Feature: Kayak

  Scenario: Kayak fly page
    Given I navigate kayak page
    When I am going to booking from "Doha" to "Narita"
    Then I check the fly

  Scenario: Kayak final page
    Given I navigate kayak page
    When I am going to booking from "Doha" to "Narita"
    Then I check the final fly page

