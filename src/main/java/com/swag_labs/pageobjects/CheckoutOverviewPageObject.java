package com.swag_labs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.swag_labs.core.BaseClass;

public class CheckoutOverviewPageObject extends BaseClass {

    By btnCancel = By.xpath("//button[@id='cancel']");
    By btnFinish = By.xpath("//button[@id='finish']");
    By btnBackHome = By.xpath("//button[@id='back-to-products']");
    By completeText = By.xpath("//div[@class='complete-text']");
    By completeHeader = By.xpath("//h2[@class='complete-header']");
    By prices = By.xpath("//div[@class='inventory_item_price']");
    By itemNames = By.xpath("//div[@class='inventory_item_name']");
    By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
    By total = By.xpath("//div[@class='summary_info_label summary_total_label']");
    By tax = By.xpath("//div[@class='summary_tax_label']");

    
    public void verifyInfo() {
        List<WebElement> itemNm = webDriver.findElements(itemNames);
        List<WebElement> prc = webDriver.findElements(prices);
        
        String[] strSubtotal = webDriver.findElement(subTotal).getText().split(" ");
        double dblSubtotal = Double.parseDouble(strSubtotal[2].substring(1));
        
        String[] strTax = webDriver.findElement(tax).getText().split(" ");
        double dblTax = Double.parseDouble(strTax[1].substring(1));

        String[] strTotal = webDriver.findElement(total).getText().split(" ");
        double dblFinalTotal = Double.parseDouble(strTotal[1].substring(1));
        
        Double dblTotal = dblSubtotal + dblTax;

        Assert.assertTrue(dblTotal == dblFinalTotal, "Failed. Sum of item prices does not match");

        Assert.assertEquals(itemNm.get(0).getText(), "Sauce Labs Backpack", "Failed. First item is not 'Sauce Labs Backpack'"); 
        
        Assert.assertEquals(itemNm.get(1).getText(), "Sauce Labs Bike Light", "Failed. Second item is not 'Sauce Labs Bike Light'");
    }
    
    public void clickButton(String btn) {
        switch (btn) {
            case "Finish": webDriver.findElement(btnFinish).click();break;
            case "Back Home": webDriver.findElement(btnBackHome).click();break;
        }
    }
    
    public void messageDisplayed(String msg) {
        Assert.assertTrue(webDriver.findElement(completeHeader).isDisplayed(), "Failed. Transaction did not complete successfully");
        
        Assert.assertEquals(webDriver.findElement(completeText).getText(), msg, "Failed. Transaction did not complete successfully");        
    }
    
}
