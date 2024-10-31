Feature: Invalid Cart Data Retrieval
  @cart
  Scenario Outline: Fetch Invalid Single Cart with ID
    Given The BaseURI for DummyJson
    When User calls GetSingleCartAPI with GET http request and id "<ID>"
    Then The API call is failed with status code 404
    And message in response is "Cart" with id "<ID>" not found

    Examples:
      |ID|
      |0|
      |500|