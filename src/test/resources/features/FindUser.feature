Feature: Find user details

  Scenario: Find user details with username Samantha
    Given I search for User "Samantha"
    When I find user "Samantha"
