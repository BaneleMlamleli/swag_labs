package com.swag_labs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.swag_labs.core.BaseClass;

public class ProductsPageObject extends BaseClass{
    
    By productTitle = By.xpath("//span[@class='title']");
    By productDiv = By.xpath("//div[@class='inventory_item']");
    By image = By.xpath("//div[@class='inventory_item_img']");
    By itemName = By.xpath("//div[normalize-space(@class)='inventory_item_name']");
    By description = By.xpath("//div[@class='inventory_item_desc']");
    By price = By.xpath("//div[@class='inventory_item_price']");
    By button = By.xpath("//button[normalize-space(@class)='btn btn_primary btn_small btn_inventory']");
    

    public void productsPage() {
        // check url, productTitle
        assert webDriver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html") && webDriver.findElement(productTitle).isDisplayed() : "Failed. Product page not successfully verified";
        
    }

    public void allProductsAreDisplayed() {
        System.out.println("All products");
        // verify all images are displayed
        // 
        List<WebElement> prodDiv = webDriver.findElements(productDiv);
        assert prodDiv.size() == 6 : "Failed. Not all products are displayed";
    }
    
    public void verifyProductDetails() {
        System.out.println("Verify products");
        List<WebElement> prodDiv = webDriver.findElements(productDiv);
        List<WebElement> img = webDriver.findElements(image);
        List<WebElement> itemNm = webDriver.findElements(itemName);
        List<WebElement> desc = webDriver.findElements(description);
        List<WebElement> prc = webDriver.findElements(price);
        List<WebElement> btn = webDriver.findElements(button);

        for (WebElement image : img) {
            assert image.getSize() != null : "Failed. Missing image in one of the products";
            // if (image.getSize() == null) {
            //     System.out.println("Failed. Missing image in one of the products");
            // }
        }

        for (int i = 0; i < prodDiv.size(); i++) {
            assert itemNm.get(i).getText() != null : "Failed. Missing item name in one of the products";
            assert desc.get(i).getText() != null : "Failed. Missing description in one of the products";
            assert prc.get(i).getText() != null : "Failed. Missing price in one of the products";
            assert btn.get(i).getText() != null : "Failed. Check one of the product's buttons";
        }
    }
}