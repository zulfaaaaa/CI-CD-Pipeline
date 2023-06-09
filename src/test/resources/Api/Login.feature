Feature: As a user i want to update user data

  Scenario: As a user i want to update user data so that user data can be updated
    Given user set valid PUT endpoint
    When user send PUT HTTP request
    Then user send update user data
    And user received HTTP response code 200