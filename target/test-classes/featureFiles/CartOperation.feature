Feature: Cart operations

  Background: Navigate to Katalon shop website
    Given I launch "katalonUrl"

  Scenario Outline: Add and remove items from the shopping cart
    Given I add "<itemCount>" random items to my cart
    When I view my cart
    Then I find total "<itemCount>" listed in my cart
    When I search for lowest price item
    And I am able to remove the lowest price item from my cart
    Then I am able to verify "<updatedCount>" items in my cart
    Examples:
      | itemCount | updatedCount |
      | 4         | 3            |