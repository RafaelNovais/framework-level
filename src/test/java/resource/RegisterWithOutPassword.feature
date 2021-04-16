@tag
Feature: Register a new user without password
  Try to register a new user without password

  @tag1
  Scenario: Register a new user without password
    Given I want to use the service to register a new user

    When I set email "challenge@automation.com"

    Then I validate if my response is "400"


