Feature: user

  Scenario: Create user
    When I create user
    Then I check create user

  Scenario Outline: Try to create user
    When I try to create user "<string>"
    Then I should see "201" status code
    Examples:
      | Task              | StatusCode |
      | Success           | 201        |
      | WithoutName       | 201        |
      | WithoutJob        | 201        |
      | WithoutJobAndName | 201        |

  Scenario: User Check
    When I get user
    Then I check user

  Scenario: Try to user Check
    When I try to get user
    Then I should see "200" status code

  Scenario: Users check
    When I get users
    Then I check users

  Scenario: Try to users check
    When I try to get users
    Then I should see "200" status code

  Scenario: Compare the user
    When I get user
    And I get users
    Then I compare the user

