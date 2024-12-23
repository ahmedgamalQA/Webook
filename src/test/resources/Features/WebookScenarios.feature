@WebTests
Feature: WeBook Website
  Sample test to use as basis for conversion


  Background:
    Given the user navigates to the homepage

  @TC1
  Scenario: Register a new user account
    When the user clicks the Sign Up button on the homepage
    And the user fills in all required fields
    Then the user should be logged in successfully
    And the user's username and email should be correct

  @TC2
    Scenario: TC2 :user search
      When user search by "Les Deux Magots" in search field
      Then Assert the title of the result is contains: "Les Deux Magots"
      And verify the search results contains "Les Deux Magots"

  @TC3
    Scenario: TC3: user filter
    When user search by "Al Shabab" in search field
    And Filter to display "Riyadh" location Only
    Then Assert the search results contains "Riyadh"