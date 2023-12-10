package com.swag_labs.stepdef;

import org.testng.Assert;

import com.swag_labs.core.BaseClass;
import io.cucumber.java.en.*;
import com.swag_labs.pageobjects.LoginPageObject;
public class Login{

    LoginPageObject login = new LoginPageObject();
    
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        BaseClass.launchBrowserWithWebsiteHomePage();
    }
    
    @When("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enter_username_and_password(String username, String password) {
        login.enterCredentials(username, password);
    }

    @And("^click on the \"([^\"]*)\" button")
    public void click_on_the_login_button(String txtLogin) {
        login.clickLoginButton(txtLogin);
    }

    @Then("user is redirected to the products page")
    public void user_is_redirected_to_the_products_page() {
        Assert.assertTrue(login.confirmRedirectToProductsPage(), "Current page is not a Products page");
    }

    @Then("^error message \"([^\"]*)\" is displayed$")
    public void error_message_is_displayed(String errMessage){
        login.errorMessage(errMessage);
    }
}