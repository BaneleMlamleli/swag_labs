package com.swag_labs.pageobjects;

import org.openqa.selenium.By;
import com.swag_labs.core.BaseClass;
public class LoginPageObject extends BaseClass{

    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By btnLogin = By.xpath("//input[@id='login-button']");
    By productPage = By.xpath("//span[@class='title']");
    By errMsg = By.xpath("//h3[@data-test='error']");

    public void enterCredentials(String usernm, String passwrd) {
        webDriver.findElement(username).sendKeys(usernm);
        webDriver.findElement(password).sendKeys(passwrd);
    }

    public void clickLoginButton(String txtLogin) {
        webDriver.findElement(btnLogin).click();
    }
    
    public void confirmRedirectToProductsPage() {
        boolean confirmation = false;
        String productPageUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println("URL: " + webDriver.getCurrentUrl());
        if ((webDriver.getCurrentUrl().equalsIgnoreCase(productPageUrl))
                && (webDriver.findElement(productPage).isDisplayed())) {
            confirmation = true;
        }
        // return confirmation;
        assert confirmation : "Current page is not a Products page";
    }

    public void errorMessage(String errMessage){
        if (webDriver.findElement(errMsg).isDisplayed()) {
            assert webDriver.findElement(errMsg).getText() == "Username and password do not match any user in this service";
        }
    }
}