Feature: client should be able to search

  @IntegrationTest
  Scenario: client makes call to search
    When client search for something
    Then client receive result
