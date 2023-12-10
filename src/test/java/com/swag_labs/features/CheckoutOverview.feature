@CheckoutOverview
Feature: Checkout product

    Checkout the purchased product/s

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page
        And user adds Backpack and T-Shirt in the cart
        And user click on the Cart
        And user verify items and quantity
        And checkout

    Scenario: Checkout purchased product/s
        When user enter "firstname", "lastname", "postalcode"
        And user click on the continue button
        Then user is redirected to the checkout overview page
        And product, total cost and checkout information is displayed
        And user click on button "Finish"
        And the message "Your order has been dispatched, and will arrive just as fast as the pony can get there!" is displayed
        And user click on button "Back Home"