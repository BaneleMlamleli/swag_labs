@BurgerMenuOptions
Feature: Burger menu navigation on the website

    Testing the Burger navigation menu options

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario: Test 'All Items' and 'Reset App State' in the burger menu options
        Given user clicks on the "burger menu"
        When user clicks on "Reset App State"
        And items are removed from the cart
        And user click on "All Items"
        Then user is redirected to the home page

    Scenario: Test 'About' and 'Logout' in the burger menu options
        Given user clicks on the "burger menu"
        When user click on "About"
        And user is redirected to "saucelabs" home page with title "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing"
        And user clicks on "Logout"
        Then login page is displayed