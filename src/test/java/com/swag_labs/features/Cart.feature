@Cart
Feature: Cart verification

    Verify cart has the same amount of products as speficied on the shopping cart badge

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario: Check products
        Given user is on the Cart page
        When user checks if there are products in the Cart
        Then product quantity much match with the number speficied on the shopping cart badge
        And click on "Continue Shopping" to go back to the products page