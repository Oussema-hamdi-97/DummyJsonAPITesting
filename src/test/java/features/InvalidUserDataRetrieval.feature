Feature: Invalid User Data Retrieval
  @invalidTestUser
  Scenario Outline: Fetch Single User
    Given The BaseURI for DummyJson
    When User calls GetUserAPI with GET http request using "<ID>"
    Then The API call is failed with status code 404
    And message in response is "User" with id "<ID>" not found

    Examples:
      |ID|
      |0 |
      |5000 |