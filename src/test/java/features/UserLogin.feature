Feature: User Login Feature

    Scenario Outline: Fetch Single User
      Given The BaseURI for DummyJson
      When User calls GetUserAPI with GET http request using "<ID>"
      Then The API call is success with status code 200
      And Username and password are stored
      Examples:
        |ID|
        |30 |

    Scenario: Valid User Login
      Given The BaseURI for DummyJson
      And Access Token Expire Time in minutes 30
      When User calls UserLoginAPI with POST http request
      Then The API call is success with status code 200

  @login
  Scenario: Invalid User Login
    Given The BaseURI for DummyJson
    And Access Token Expire Time in minutes 30
    When User calls UserLoginAPI with POST http request with invalid Username "<Username>" and Password "<Password>"
    Then The API call is failed with status code 400
    And message in response is "Invalid credentials"