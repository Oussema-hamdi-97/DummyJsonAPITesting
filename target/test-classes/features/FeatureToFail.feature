Feature: To fail

  Scenario: Fetch All Carts
    Given The BaseURI for DummyJson
    When User calls GetCartAPI with GET http request
    Then The API call is success with status code 404