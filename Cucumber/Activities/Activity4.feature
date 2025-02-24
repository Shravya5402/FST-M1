@activity4
Feature: Data driven test without Example

Scenario: Testing with Data from Scenario
    Given new User is on Login page
    When new User enters "admin" and "password"
    Then new Read the page title and confirmation message
    And new Close the Browser