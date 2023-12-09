package com.swag_labs.stepdef;

import com.swag_labs.pageobjects.CheckoutInformationPageObject;

import io.cucumber.java.en.*;

public class CheckoutInformation {
    
    CheckoutInformationPageObject checkoutInfo = new CheckoutInformationPageObject();

    @And("checkout")
    public void checkout() {
        checkoutInfo.checkoutItems();
    }
    @When("^user enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void user_enter_checkout_information(String name, String surname, String postalcode){
        checkoutInfo.checkoutInformation(name, surname, postalcode);
    }

    @And("user click on the continue button")
    public void user_click_on_the_continue_button(){
        checkoutInfo.continueWithOrder();
    }
    
    @Then("error message is displayed")
    public void error_message_is_displayed() {
        checkoutInfo.errorMessage();
    }

    @Then("user is redirected to the checkout overview page")
    public void redirected_to_the_checkout_overview_page() {
        checkoutInfo.redirectedToCheckoutOverviewPage();
    }
}
