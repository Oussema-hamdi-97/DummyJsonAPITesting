Feature: User Login Feature

    @login
    Scenario Outline: Fetch Single User
      Given The BaseURI for DummyJson
      When User calls GetUserAPI with GET http request using "<ID>"
      Then The API call is success with status code 200
      And Username and password are stored
      Examples:
        |ID|
        |30 |
    @login
    Scenario: Valid User Login
      Given The BaseURI for DummyJson
      And Access Token Expire Time in minutes 30
      When User calls UserLoginAPI with POST http request
      Then The API call is success with status code 200