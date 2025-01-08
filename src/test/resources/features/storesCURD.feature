Feature: Bestbuy Application

  As a user I want to test Bestbuy Application

  @smoke
  Scenario Outline: Verify CRUD operation of Bestbuy Application
    Given Bestbuy Application is running
    When I create a new store using name "<name>" type "<type>" address "<address>" address "<address2>" city "<city>" state "<state>" zip "<zip>"
    Then I delete the store that created with id
    Then The store deleted successfully from the application

    Examples:

      | name   | type      | address                | address2 | city   | state | zip   |
      | palakk | BigBox233 | 135135644 Ridgedale Dr | czccc    | Sussex | MN    | 56097 |