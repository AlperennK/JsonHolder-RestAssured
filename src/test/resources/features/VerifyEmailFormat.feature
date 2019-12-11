# new feature
# Tags: optional
    
Feature: All email addreses should have valid email format
    
Scenario: I should verify all email addresses are valid
    When I check all email addresses
    Then I should have all email addreses in valid format
