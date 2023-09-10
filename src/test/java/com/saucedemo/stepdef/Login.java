package com.saucedemo.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.saucedemo.core.BaseClass;
import io.cucumber.java.en.*;

public class Login extends BaseClass {

    final String BROWSER = "chrome"; //chrome, firefox, edge
    
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }
    
    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_username_and_password(String username, String password) {
        webDriver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("^click on the \"([^\"]*)\" button")
    public void click_on_the_login_button(String login) {
        webDriver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("user is redirected to the products page")
    public void user_is_redirected_to_the_products_page() {
        System.out.println("product page");
    }

    // \"(.*?)\"
    @Then("^error message \"([^\"]*)\" is displayed$")
    public void error_message_is_displayed(String errorMessage){
        System.out.println("error messsage");
    }
}