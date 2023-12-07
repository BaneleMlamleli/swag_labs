package com.swag_labs.stepdef;

import com.swag_labs.pageobjects.FilterPageObject;

import io.cucumber.java.en.*;

public class Filter {

    FilterPageObject filterPageObject = new FilterPageObject();
    
    @Given("user is on the Products page and clicks on the filter dropdown")
    public void user_is_on_the_products_page_and_clicks_on_the_filter_dropdown() {
        filterPageObject.filterDropdown();
    }

    @When("^user select \"([^\"]*)\"$")
    public void user_select_filter_option(String filter_option) {
        filterPageObject.selectFilterOption(filter_option);
    }
    
    @Then("product is displayed according to the selected filter")
    public void product_is_displayed_according_to_the_selected_filter() {
        filterPageObject.confirmFilterEffect();
    }
}
