Feature: Invalid Recipe Data Retrieval

  @recipe
  Scenario Outline: Fetch Invalid Single Product
    Given The BaseURI for DummyJson
    When User calls GetSingleRecipeAPI with GET http request and id "<ID>"
    Then The API call is failed with status code 404
    And message in response is "Recipe" with id "<ID>" not found

    Examples:
      |ID|
      |0 |
      |5000 |