Feature: Delete product

  Scenario: Delete products added to the product page
    Given user enters product into cart
    When the product that the user enters into the cart, clicks on the product
    And user clicks the Remove button
    Then the product was successfully deleted
