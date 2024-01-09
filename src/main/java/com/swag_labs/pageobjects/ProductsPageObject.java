package com.swag_labs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.swag_labs.core.BaseClass;

public class ProductsPageObject extends BaseClass{
    
    By productTitle = By.xpath("//span[@class='title']");
    By productDiv = By.xpath("//div[@class='inventory_item']");
    By image = By.xpath("//div[@class='inventory_item_img']");
    By itemName = By.xpath("//div[normalize-space(@class)='inventory_item_name']");
    By description = By.xpath("//div[@class='inventory_item_desc']");
    By price = By.xpath("//div[@class='inventory_item_price']");
    By button = By.xpath("//button[normalize-space(@class)='btn btn_primary btn_small btn_inventory']");
    

    public boolean productsPage() {
        // check url, productTitle
        return webDriver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html") && webDriver.findElement(productTitle).isDisplayed();        
    }

    public boolean allProductsAreDisplayed() {
        List<WebElement> prodDiv = webDriver.findElements(productDiv);
        return prodDiv.size() == 6;
    }
    
    // NOTE: This method can be done a lot better so that it's more precise
    public void verifyProductDetails() {
        List<WebElement> prodDiv = webDriver.findElements(productDiv);
        List<WebElement> img = webDriver.findElements(image);
        List<WebElement> itemNm = webDriver.findElements(itemName);
        List<WebElement> desc = webDriver.findElements(description);
        List<WebElement> prc = webDriver.findElements(price);
        List<WebElement> btn = webDriver.findElements(button);

        // NOTE: I think a better approach would be to check the images response code
        for (WebElement image : img) {
           Assert.assertTrue(image.getSize() != null, "Failed. Missing image in one of the products");

        }

        for (int i = 0; i < prodDiv.size(); i++) {
             Assert.assertTrue(itemNm.get(i).getText() != null, "Failed. Missing item name in one of the products");
             Assert.assertTrue(desc.get(i).getText() != null, "Failed. Missing description in one of the products");
             Assert.assertTrue(prc.get(i).getText() != null, "Failed. Missing price in one of the products");
             Assert.assertTrue(btn.get(i).getText() != null, "Failed. Check one of the product's buttons");
        }
    }
}