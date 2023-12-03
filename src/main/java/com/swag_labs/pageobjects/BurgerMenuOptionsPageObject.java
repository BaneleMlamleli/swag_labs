package com.swag_labs.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.swag_labs.core.BaseClass;

public class BurgerMenuOptionsPageObject extends BaseClass {

    By burgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    By allItems = By.xpath("//a[@id='inventory_sidebar_link']");
    By about = By.xpath("//a[@id='about_sidebar_link']");
    By logout = By.xpath("//a[@id='logout_sidebar_link']");
    By resetAppState = By.xpath("//a[@id='reset_sidebar_link']");
    By cart = By.xpath("//a[@class='shopping_cart_link']");
    By itemsInCart = By.xpath("//span[@class='shopping_cart_badge']");
    By productPage = By.xpath("//span[@class='title']");
    By btnRemoveItemFromCart = By.xpath("//button[text()='Remove']");

    public void clickOnElement(String clickedElement) {
        switch (clickedElement) {
            case "All Items":
                waitForElementUntilVisible(allItems);
                break;
            case "Reset App State":
                webDriver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
                waitForElementUntilVisible(resetAppState);
                break;
            case "About":
                waitForElementUntilVisible(about);
                break;
            case "Logout":
                waitForElementUntilVisible(logout);
                break;
            case "burger menu":
                waitForElementUntilVisible(burgerMenu);
                break;
            default:
                break;
        }
    }

    public void confirmRedirectToProductsPage() {
        boolean confirmation = false;
        String productPageUrl = "https://www.saucedemo.com/inventory.html";
        if ((webDriver.getCurrentUrl().equalsIgnoreCase(productPageUrl))
                && (webDriver.findElement(productPage).isDisplayed())) {
            confirmation = true;
        }
        // return confirmation;
        assert confirmation : "Current page is not a Products page";
    }

    public void removeItemsFromCart() {
        try {
            assert !webDriver.findElement(itemsInCart).isDisplayed() : "'Reset App State' passed";          
        } finally {
            // The below code is for resetting the buttons so that they read 'Add to cart' instead of 'Remove'
            List<WebElement> btnRemove = webDriver.findElements(btnRemoveItemFromCart);
            if (btnRemove.size() > 0) {
                for (WebElement webElement : btnRemove) {
                    webElement.click();
                }
            }
            System.out.println("'Reset App State' passed");
        }
    }

    public void sauceLabsHomePage(String saucelab, String title) {
        if (webDriver.getTitle().equalsIgnoreCase(title)) {
            System.out.println(saucelab + " successfully redirected to the 'About' page");
        } else {
            System.out.println(saucelab + " failed to redirect to the 'About' page");
        }
    }

    public void loginPage() {
        if (webDriver.getTitle().equalsIgnoreCase("Swag Labs")) {
            System.out.println("successfully logged out");
        } else {
            System.out.println("failed to logout");
        }
    }

    public void waitForElementUntilVisible(By element) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }
}