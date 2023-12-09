package com.swag_labs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.swag_labs.core.BaseClass;

public class CartPageObject extends BaseClass {
    
    By backpackItem = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By tShirtItem = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    By cart = By.xpath("//a[@class='shopping_cart_link']");
    By contiShopping = By.xpath("//button[@id='continue-shopping']");

    By itemsInTheCart = By.xpath("//div[@class='inventory_item_name']");
    

    public void addToCart() {
        webDriver.findElement(backpackItem).click();
        webDriver.findElement(tShirtItem).click();
    }

    public void clickCart() {
        webDriver.findElement(cart).click();
    }

    public void verifyItemsAndQuantity() {
        List<WebElement> listOfItemsInTheCart = webDriver.findElements(itemsInTheCart);

        for (int i = 0; i < listOfItemsInTheCart.size(); i++) {
            System.out.println("Items in the list: " + listOfItemsInTheCart.get(i).getText());
        }
        
        assert listOfItemsInTheCart.size() == 2 : "Failed. Expected 2 items in the cart";

        assert listOfItemsInTheCart.get(0).getText().equalsIgnoreCase("Sauce Labs Backpack") : "Failed. Backpack is not selected";
        
        assert listOfItemsInTheCart.get(1).getText().equalsIgnoreCase("Sauce Labs Bike Light"): "Failed. T-Shirt is not selected";

    }
    
    public void productsPage() {
        webDriver.findElement(contiShopping).click();
    }
}
