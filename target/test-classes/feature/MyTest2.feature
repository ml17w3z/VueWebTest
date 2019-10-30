Feature: login functionality on login page of Application

  Scenario: Verification of Login
    Given I am on the login page
    When I enter username as tester
    And I enter password as pwd
    Then Login should succeed
