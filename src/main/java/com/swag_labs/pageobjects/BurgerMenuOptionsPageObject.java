package com.swag_labs.pageobjects;

import org.openqa.selenium.By;
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

    public void clickOnElement(String clickedElement) {
        switch (clickedElement) {
            case "All Items":
                webDriver.findElement(allItems).click();
                break;
            case "Reset App State":
                // TODO: I need to write a code that click on all of the 'Remove' button/s if they are available in order to reset the app state 
                webDriver.findElement(resetAppState).click();
                break;
            case "About":
                webDriver.findElement(about).click();
                break;
            case "Logout":
                webDriver.findElement(logout).click();
                break;
            case "burger menu":
                webDriver.findElement(burgerMenu).click();
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
        if (webDriver.findElement(itemsInCart).isDisplayed()) {
            System.out.println("'Reset App State' failed");
        } else {
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
    

}