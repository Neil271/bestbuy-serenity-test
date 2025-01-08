Feature: Bestbuy Application

  As a user I want to test Bestbuy Application

  @smoke
  Scenario Outline: Verify CRUD operation of Bestbuy Application
    Given Bestbuy Application is running
    When I create a new product using name "<name>" type "<type>" price <price> upc "<upc>" shipping <shipping> desc "<desc>" manu "<manu>" model "<model>" url "<url>" image "<image>"
    And I delete the product that created with id
    Then The product deleted successfully from the application

    Examples:
      | name                              | type     | price | upc          | shipping | desc                                                                                            | manu     | model     | url                                                                                                      | image                                                                 |
      | Duracell - AAA Batteries (4-Pack) | HardGood | 4.99  | 041333424019 | 1        | Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack | Duracell | MN2400B4Z | http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC | http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg |