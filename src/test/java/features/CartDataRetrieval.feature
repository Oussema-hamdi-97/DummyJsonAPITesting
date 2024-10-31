Feature: Cart Data Retrieval

  Scenario: Fetch All Carts
    Given The BaseURI for DummyJson
    When User calls GetCartAPI with GET http request
    Then The API call is success with status code 200


  Scenario Outline: Fetch Single Cart with id
    Given The BaseURI for DummyJson
    When User calls GetSingleCartAPI with GET http request and id "<ID>"
    Then The API call is success with status code 200

    Examples:
      |ID|
      |1 |
      |5 |
      |30 |