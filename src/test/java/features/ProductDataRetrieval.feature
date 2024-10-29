Feature: Product Data Retrieval
  @validTest
  Scenario: Fetch All Product List
    Given The BaseURI for DummyJson
    When User calls GetProductAPI with GET http request
    Then The API call is success with status code 200

  @validTest
  Scenario Outline: Fetch Single Product
    Given The BaseURI for DummyJson
    When User calls GetProductAPI with GET http request using "<ID>"
    Then The API call is success with status code 200

    Examples:
    |ID|
    |1 |
    |5 |
    |55|

    @validTest
    Scenario Outline: Search Products
      Given The BaseURI for DummyJson
      When User calls SearchProductAPI with GET http request and search for "<Product>"
      Then The API call is success with status code 200
      And The total number of products is not null

      Examples:
        |Product|
        |phone |
        |phones |