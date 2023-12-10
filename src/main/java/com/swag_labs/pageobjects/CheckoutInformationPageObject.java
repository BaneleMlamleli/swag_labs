package com.swag_labs.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.swag_labs.core.BaseClass;

public class CheckoutInformationPageObject extends BaseClass {
    
    By strName = By.xpath("//input[@id='first-name']");
    By strSurname = By.xpath("//input[@id='last-name']");
    By strZipcode = By.xpath("//input[@id='postal-code']");
    By btnContinue = By.xpath("//input[@id='continue']");
    By errorMessage = By.xpath("//h3[@data-test='error']");
    By btnCheckout = By.xpath("//button[@id='checkout']");

    public void checkoutItems() {
        webDriver.findElement(btnCheckout).click();
    }

    public void checkoutInformation(String name, String surname, String postalcode) {
        webDriver.findElement(strName).sendKeys(name);
        webDriver.findElement(strSurname).sendKeys(surname);
        webDriver.findElement(strZipcode).sendKeys(postalcode);
    }
    
    public void continueWithOrder() {
        webDriver.findElement(btnContinue).click();
    }

    public boolean errorMessage() {
        return !webDriver.findElement(errorMessage).isDisplayed();
    } 

    public void redirectedToCheckoutOverviewPage() {
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }
}
