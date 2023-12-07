package com.swag_labs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.swag_labs.core.BaseClass;

public class FilterPageObject extends BaseClass{
    
    By filter = By.xpath("//select[@class='product_sort_container']");
    By itemName = By.xpath("//div[normalize-space(@class)='inventory_item_name']");
    By price = By.xpath("//div[@class='inventory_item_price']");

    String selectedOption = "";


    public void filterDropdown() {
        webDriver.findElement(filter).click();
    }

    public void selectFilterOption(String filter_option) {
        Select filterOptions = new Select(webDriver.findElement(filter));
        switch (filter_option) {
            case "Name (A to Z)":
                filterOptions.selectByVisibleText(filter_option);
                selectedOption = filter_option; break;
            case "Name (Z to A)":
                filterOptions.selectByVisibleText(filter_option);
                selectedOption = filter_option; break;
            case "Price (low to high)":
                filterOptions.selectByVisibleText(filter_option);
                selectedOption = filter_option; break;
            case "Price (high to low)":
                filterOptions.selectByVisibleText(filter_option);
                selectedOption = filter_option; break;
            default:
                System.out.println("Default option selected");
                selectedOption = "Name (A to Z)"; break;
        }
    }
    
    public void confirmFilterEffect() {
        List<WebElement> itemNm = webDriver.findElements(itemName);
        List<WebElement> prc = webDriver.findElements(price);
        switch (selectedOption) {
            case "Name (A to Z)":
                assert itemNm.get(0).getText().equalsIgnoreCase("Sauce Labs Backpack"): "Failed. Items are not displayed in alphabetical order"; break;
            case "Name (Z to A)":
                assert itemNm.get(0).getText().equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)"): "Failed. Items are not displayed from Z to A"; break;
            case "Price (low to high)":
                assert prc.get(0).getText().equalsIgnoreCase("$7.99"): "Failed. Items are not displayed from lowest to highest price"; break;
            case "Price (high to low)":
                assert prc.get(0).getText().equalsIgnoreCase("$49.99"): "Failed. Items are not displayed from highest to lowest price"; break;
            default:
                System.out.println("Default option selected"); break;
        }
    }
}
