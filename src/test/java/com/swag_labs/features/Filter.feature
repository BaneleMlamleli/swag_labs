@Filter
Feature: Products filters

    Products filters for searching or displaying product information in a certain manner

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario Outline: filters
        Given user is on the Products page and clicks on the filter dropdown
        When user select "<filter option>"
        Then product is displayed according to the selected filter
        Examples:
            | filter option       |
            | Name (A to Z)       |
            | Name (Z to A)       |
            | Price (low to high) |
            | Price (high to low) |