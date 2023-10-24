Feature: Check out the product

  Scenario: Checkout product with valid data
    Given click the "Add to Cart" button on one of the products
    When Click the "Cart" icon in the top right corner
    And Click the "Checkout" button
    And Enter first name
    And Enter last name
    And Enter postal code
    And Click the "Continue" button
    Then Click the "Finish" button