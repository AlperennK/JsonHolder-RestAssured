Feature: Find user details

  Scenario: Find user details with username Samantha
    Given I have userId for "Samantha"
    When I query  posts for specific user with userid parameter
    Then I should get "50" emails totally