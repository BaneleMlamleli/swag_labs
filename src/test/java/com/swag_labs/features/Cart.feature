@Cart
Feature: Cart verification

    Verify cart has the same amount of products as speficied on the shopping cart badge

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario: Checkout products
        Given user adds Backpack and T-Shirt in the cart
        When user click on the Cart
        Then user verify items and quantity
        And click on Continue Shopping to go back to the products page