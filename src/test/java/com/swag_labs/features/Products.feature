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
        When all products are displayed
        Then verify each product has a name, image, description, price and button