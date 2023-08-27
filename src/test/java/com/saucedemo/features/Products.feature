@Products
Feature: Verify product information

    Verify all product information (product description, price, picture, name and Add or Remove button) is displayed for each product

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario: Verify all products information
        Given user is on the products page
        When All products are displayed
        Then each product name is displayed
        And product image is displayed
        And product description is displayed
        And price is displayed
        And Add to cart or Remove button is displayed