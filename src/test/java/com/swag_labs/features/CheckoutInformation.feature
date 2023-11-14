@CheckoutInformation
Feature: User delivery information

    User delivery information

    Background: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page

    Scenario: User delivery checkout information
        Given user is on the Checkout Information page
        When user enter "<firstname>","<lastname>", "<postalcode>"
        And user click on button "Continue"
        Then user is redirected to the "Checkout: Overview" page
        Examples:
            | firstname     | lastname     | postalcode |
            |               | TestLastname | 1010       |
            | TestFirstname |              | 1010       |
            | TestFirstname | TestLastname |            |
            | Banele        | Mlamleli     | 8000       |