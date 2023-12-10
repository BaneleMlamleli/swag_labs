package com.swag_labs.stepdef;

import com.swag_labs.pageobjects.CheckoutOverviewPageObject;

import io.cucumber.java.en.*;

public class CheckoutOverview {

    CheckoutOverviewPageObject checkoutOverviewPageObject = new CheckoutOverviewPageObject();
    
    @And("product, total cost and checkout information is displayed")
    public void product_total_cost_and_checkout_information_is_displayed() {
        checkoutOverviewPageObject.verifyInfo();
    }
    
    @And("user click on button {string}")
    public void user_click_on_button(String btn) {
        checkoutOverviewPageObject.clickButton(btn);
    }

    @And("the message {string} is displayed")
    public void the_message_is_displayed(String message) {
        checkoutOverviewPageObject.messageDisplayed(message);
    }    
}
