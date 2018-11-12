@all
Feature: Craiglist Page Testing

  Background:
    Given open craiglist webpage
    Given select language English

  Scenario: Open Housing page and check default sorting. Also check High and Low price sorting.
    Then check filters in dropdown
    And check High price sorting
    Then check Lowest price sorting

  Scenario: Make Search and check sorting possibilities
    When I search for "house"
    And check dropdown sorting after search