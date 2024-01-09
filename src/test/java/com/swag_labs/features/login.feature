@Login
Feature: login screen

    Login screen that will test all the login credentials with passing and failing scenarios

    @correct_credentials
    Scenario Outline: login with correct credentials
        Given user is on the login page
        When user enter username "standard_user" and password "secret_sauce"
        And click on the "Login" button
        Then user is redirected to the products page
    # Examples:
    #     | username                | password     |
    #     | standard_user           | secret_sauce |
    #     | locked_out_user         | secret_sauce |
    #     | performance_glitch_user | secret_sauce |

    @incorrect_credentials
    Scenario Outline: login with incorrect credentials
        Given user is on the login page
        When user enter "<password>" and "<username>"
        And click on the "Login" button
        Then error message "Epic sadface: Username and password do not match any user in this service" is displayed
        Examples:
            | username                | password                 |
            | standard_user           | wrong_password1234       |
            | standard_user           | select * from users      |
            | locked_out_user         |                          |
            |                         | secret_sauce             |
            |                         |                          |
            | problem_user            | secret_sauce             |
            | problem_user            | 1234567890               |
            | select * from users     | 1234567890               |
            | performance_glitch_user | !@#$%^&*\)(_+\}{:"  <>?" |