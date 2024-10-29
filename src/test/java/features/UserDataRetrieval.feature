Feature: User Data Retrieval
  @validTestUser
  Scenario: Fetch All Users
    Given The BaseURI for DummyJson
    When User calls GetUserAPI with GET http request
    Then The API call is success with status code 200

  @validTestUser
  Scenario Outline: Fetch Single User
    Given The BaseURI for DummyJson
    When User calls GetUserAPI with GET http request using "<ID>"
    Then The API call is success with status code 200

    Examples:
      |ID|
      |1 |
      |5 |
      |55|