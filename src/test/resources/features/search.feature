Feature: Wikipedia search

  Scenario: Search hotel by name and validation rating
    Given Hotel for search is "Milan"
    When User opens booking search page
    And Does search
    Then Wiki page "Ibis Milano Centro" is on the first page
    And Hotel "Ibis Milano Centro" raiting is "7.9"
    