@tag
Feature: Create Users
  Function to create news users

  @tag1
  Scenario: Create a new user
    Given I use user creation service
   
    When I set name "Toy"
    And  I set job "singer"
    
    Then I validate my response is "201"
   
