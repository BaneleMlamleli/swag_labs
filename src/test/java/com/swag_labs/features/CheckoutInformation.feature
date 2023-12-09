@CheckoutInformation
Feature: User delivery information

    User delivery information

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page
        And user adds Backpack and T-Shirt in the cart
        And user click on the Cart
        And user verify items and quantity
        And checkout

    @incorrectInformation
    Scenario: Incorrect user delivery checkout information
        When user enter "<firstname>", "<lastname>", "<postalcode>"
        And user click on the continue button
        Then error message is displayed
        Examples:
            | firstname     | lastname     | postalcode         |
            | TestFirstname |              |                    |
            |               | TestLastname |                    |
            |               |              | 1010               |
            |               |              |                    |
            | TestFirstname | TestLastname |                    |
            |               | TestLastname | sfsg3!@4563dfgdf42 |
            | TestFirstname |              | sfsf*#)33df"g(df42 |

    @correctInformation
    Scenario: Correct user delivery checkout information
        When user enter "<firstname>", "<lastname>", "<postalcode>"
        And user click on the continue button"
        Then user is redirected to the checkout overview page
        Examples:
            | firstname | lastname | postalcode |
            | Banele    | Mlamleli | 8000       |