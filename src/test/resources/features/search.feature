Feature: Wikipedia search

#  Scenario: Search wiki page for ALICE
#    Given Keyword for search is "ALICE company"
#    When User does search
#    Then Wiki page "ALICE (company)" is on the first page
#
#  Scenario: Search wiki page for Google
#    Given Keyword for search is "Google Company"
#    When User does search
#    Then Wiki page "Google" is on the first page
#
#  Scenario: Search wiki page for Microsoft
#    Given Keyword for search is "Microsoft Company"
#    When User does search
#    Then Wiki page "Microsoft" is on the first page

  Scenario: Search hotel by name and validation rating
    Given Hotel for search is "Milan"
    When User opens booking search page
    And Does search
    Then Wiki page "Ibis Milano Centro" is on the first page
    And Hotel "Ibis Milano Centro" raiting is "7.9"
    