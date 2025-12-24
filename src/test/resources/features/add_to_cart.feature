Feature:  Add Product To Cart
  


  Scenario: User adds product to cart and places order
    Given user access essence application
    When  user selects one popular product
    And  user adds product to cart 
    And user proceeds to checkout 
    And user enter all address details
    And user click places the order