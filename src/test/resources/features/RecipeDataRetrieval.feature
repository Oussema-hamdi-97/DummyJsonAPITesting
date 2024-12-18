Feature: Recipe Data Retrieval


  Scenario: Fetch All Recipes
    Given The BaseURI for DummyJson
    When User calls GetRecipeAPI with GET http request
    Then The API call is success with status code 200

  Scenario Outline: Fetch Single Recipe with id
    Given The BaseURI for DummyJson
    When User calls GetSingleRecipeAPI with GET http request and id "<ID>"
    Then The API call is success with status code 200

    Examples:
      |ID|
      |1 |
      |5 |
      |30 |