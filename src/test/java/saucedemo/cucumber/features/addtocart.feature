Feature: Add To Cart Product
  Scenario: Add to cart via product page
    Given user login to user account
    When user choose the product
    And user click Add To Cart button
    Then the product successfully entered to Your Cart page