@Checkout
Feature: Checkout product

    Checkout the purchased product/s

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario: Checkout purchased product/s
        Given user is on the checkout page
        When user click on "Checkout" button
        # The below step has its own feature tested
        And user enter checkout information
        Then click on "Continue" button
        And product, total cost and checkout information is displayed
        And user click on button "Finish"
        And The message "Thank you for your order! Your order has been dispatched, and will arrive just as fast as the pony can get there!" is displayed
        And user click on button "Back Home" to go back to the products page