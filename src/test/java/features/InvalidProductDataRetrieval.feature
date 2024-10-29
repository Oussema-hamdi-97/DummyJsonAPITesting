Feature: Invalid Product Data Retrieval
  @invalidTestProduct
  Scenario Outline: Fetch Invalid Single Product
    Given The BaseURI for DummyJson
    When User calls GetProductAPI with GET http request using "<ID>"
    Then The API call is failed with status code 404
    And message in response is "Product" with id "<ID>" not found

    Examples:
      |ID|
      |0 |
      |5000 |

  @invalidTestProduct
  Scenario Outline: Search Invalid Products
    Given The BaseURI for DummyJson
    When User calls SearchProductAPI with GET http request and search for "<Product>"
    Then The API call is success with status code 200
    And The total number of products is null

    Examples:
      |Product|
      |randomtest |
      |abcdefgh |